package com.example.a11_unscrambleapp.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.a11_unscrambleapp.data.MAX_NO_OF_WORDS
import com.example.a11_unscrambleapp.data.SCORE_INCREASE
import com.example.a11_unscrambleapp.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {

    // Game UI state
    //Solo es accesible y editable desde GameViewModel
    private val _uiState = MutableStateFlow(GameUiState())

    //Propiedad de solo lectura para IU se inicializa con el valor de _uiState.asStateFlow()
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    //palabra desordenada actual
    private lateinit var currentWord: String

    // Set of words used in the game
    private var usedWords: MutableSet<String> = mutableSetOf()

    var userGuess by mutableStateOf("")
        private set

    init {
        resetGame()
    }

    /**
     * Devuelve una palabra desordenada obtenida desde una lista [allWords].
     * Actualiza con la palabra usada la lista [usedWords]
     *
     * @return Devuelve una palabra desordenada.
     */
    private fun pickRandomWordAndShuffle(): String {
        // Continue picking up a new random word until you get one that hasn't been used before
        currentWord = allWords.random()

        if (usedWords.contains(currentWord)) {
            return pickRandomWordAndShuffle()
        } else {
            usedWords.add(currentWord)
            return shuffleCurrentWord(currentWord)
        }
    }

    /**
     * Desordena la palabra actual.
     *
     * Esta función toma una palabra como entrada [word] y la devuelve desordenada.
     *
     * @param word La palabra que se va a desordenar.
     * @return La palabra desordenada.
     *
     * **Nota:** Esta función se asegura de que la palabra desordenada sea diferente a la palabra original.
     */
    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()
        // Scramble the word
        tempWord.shuffle()
        while (String(tempWord).equals(word)) {
            tempWord.shuffle()
        }
        return String(tempWord)
    }

    /**
     * Reinicia el juego.
     *
     * Esta función reinicia el estado del juego a su estado inicial.
     *
     * Las acciones que realiza son:
     *  * Limpia la lista de palabras usadas [usedWords].
     *  * Actualiza el estado de la interfaz de usuario [_uiState] con un nuevo valor.
     *      * El nuevo valor del estado contiene una palabra nueva y barajada usando la función [pickRandomWordAndShuffle()] .
     */
    fun resetGame() {
        usedWords.clear()
        _uiState.value = GameUiState(currentScrambledWord = pickRandomWordAndShuffle())

    }

    /**
     * Actualiza la suposición del usuario.
     *
     * Esta función actualiza la variable [userGuess] con la nueva suposición del usuario [guessedWord].
     *
     * @param guessedWord La nueva suposición del usuario.
     */
    fun updateUserGuess(guessedWord: String) {
        userGuess = guessedWord
    }

    /**
     * Comprueba la suposición del usuario.
     *
     * Esta función compara la suposición del usuario [userGuess] con la palabra actual [currentWord].
     * Si las palabras coinciden (ignorando mayúsculas y minúsculas), la función aumenta la puntuación del usuario y actualiza el estado del juego.
     * Si las palabras no coinciden, la función muestra un error en la interfaz de usuario e indica que la suposición del usuario es incorrecta.
     * También se reinicia la suposición del usuario a una cadena vacía.
     */
    fun checkUserGuess() {
        if (userGuess.equals(currentWord, ignoreCase = true)) {
            // User's guess is correct, increase the score
            val updatedScore = _uiState.value.score.plus(SCORE_INCREASE)
            updateUserGuess("")
            updateGameState(updatedScore)
        } else {
            // User's guess is wrong, show an error
            _uiState.update { currentState ->
                currentState.copy(isGuessedWordWrong = true)
            }
            // Reset user guess
            updateUserGuess("")

        }
    }

    /**
     * Actualiza el estado del juego en base a la puntuación nueva.
     *
     * Esta función actualiza el estado interno del juego dependiendo de si se trata de la última ronda o una ronda normal.
     *
     * @param updatedScore La nueva puntuación del jugador.
     */
    private fun updateGameState(updatedScore: Int) {
        if (usedWords.size == MAX_NO_OF_WORDS) {
            //Last round in the game
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    score = updatedScore,
                    isGameOver = true
                )
            }
        } else {
            // Normal round in the game
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    currentScrambledWord = pickRandomWordAndShuffle(),
                    score = updatedScore,
                    currentWordCount = currentState.currentWordCount.inc(),
                )

            }

        }
    }

    /**
     * Omitir la palabra actual.
     *
     * Esta función se utiliza cuando el usuario decide saltarse la palabra actual.
     * Realiza las siguientes acciones:
     *   * Actualiza el estado del juego llamando a la función `updateGameState()` y pasando la puntuación actual (`_uiState.value.score`).
     *   * Reinicia la suposición del usuario a una cadena vacía llamando a la función `updateUserGuess("")`.
     *
     **Nota:** Se asume que omitir la palabra no afecta la puntuación del usuario. Si la puntuación cambia al omitir una palabra, modifica la documentación para reflejar ese comportamiento.
     *
     */
    fun skipWord() {
        updateGameState(_uiState.value.score)
        // Reset user guess
        updateUserGuess("")
    }
}