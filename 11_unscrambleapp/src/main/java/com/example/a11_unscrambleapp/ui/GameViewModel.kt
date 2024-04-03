package com.example.a11_unscrambleapp.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.a11_unscrambleapp.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

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
     * Desordena una palabra recibida por parametro.
     *
     * @param word Palabra para desordenar.
     * @return Devuelve la palabra recibida [word], desordenada.
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
     * Reinicia el juego. Limpia [usedWords] y elige de nuevo una nueva palabra para que se inicie el juego.
     *
     */
    fun resetGame() {
        usedWords.clear()
        _uiState.value = GameUiState(currentScrambledWord = pickRandomWordAndShuffle())

    }

    fun updateUserGuess(guessedWord: String) {
        userGuess = guessedWord
    }
}