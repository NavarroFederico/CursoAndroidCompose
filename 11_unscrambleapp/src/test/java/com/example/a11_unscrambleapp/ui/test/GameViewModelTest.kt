package com.example.a11_unscrambleapp.ui.test

import com.example.a11_unscrambleapp.data.MAX_NO_OF_WORDS
import com.example.a11_unscrambleapp.data.SCORE_INCREASE
import com.example.a11_unscrambleapp.data.getUnscrambledWord
import com.example.a11_unscrambleapp.ui.GameViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class GameViewModelTest {
    private val viewModel = GameViewModel()

    /**
     * Prueba para GameViewModel: Palabra Correcta Adivinada - Puntuación Actualizada y Bandera de Error Desactivada
     *
     * Esta prueba verifica que el método checkUserGuess() en el [GameViewModel] se comporta correctamente
     * cuando el usuario adivina la palabra correctamente.
     */
    @Test
    fun gameViewModel_CorrectWordGuessed_ScoreUpdatedAndErrorFlagUnset() {
        //Preparación (Establecer el estado inicial)
        var currentGameUiState = viewModel.uiState.value
        val correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)

        //Acción (Simular la interacción del usuario)
        viewModel.updateUserGuess(correctPlayerWord)
        viewModel.checkUserGuess()

        // Aserción (Verificar el resultado esperado)
        currentGameUiState = viewModel.uiState.value
        // Assert that checkUserGuess() method updates isGuessedWordWrong is updated correctly.
        assertFalse(currentGameUiState.isGuessedWordWrong)
        // Assert that score is updated correctly.
        assertEquals(SCORE_AFTER_FIRST_CORRECT_ANSWER, currentGameUiState.score)

    }

    companion object {
        private const val SCORE_AFTER_FIRST_CORRECT_ANSWER = SCORE_INCREASE
    }

    /**
     * Prueba para GameViewModel: Suposición Incorrecta - Bandera de Error Activada
     *
     * Esta prueba verifica que el método `checkUserGuess()` en el [GameViewModel] se comporta correctamente
     * cuando el usuario adivina la palabra incorrectamente.
     */
    @Test
    fun gameViewModel_IncorrectGuess_ErrorFlagSet() {
        // Given an incorrect word as input
        // Preparación (Establecer el estado inicial)
        val incorrectPlayerWord = "and"

        viewModel.updateUserGuess(incorrectPlayerWord)
        viewModel.checkUserGuess()
        // Aserción (Verificar el resultado esperado)
        val currentGameUiState = viewModel.uiState.value
        // Assert that score is unchanged
        assertEquals(0, currentGameUiState.score)
        // Assert that checkUserGuess() method updates isGuessedWordWrong correctly
        assertTrue(currentGameUiState.isGuessedWordWrong)
    }

    /**
     * Prueba para GameViewModel: Inicialización - Primera Palabra Cargada
     *
     * Esta prueba verifica que el GameViewModel se inicialice correctamente y
     * que la primera palabra se cargue adecuadamente.
     */
    @Test
    fun gameViewModel_Initialization_FirstWordLoaded() {
        // Obtener el estado actual del juego
        val gameUiState = viewModel.uiState.value
        // Obtener la palabra sin desordenar
        val unScrambledWord = getUnscrambledWord(gameUiState.currentScrambledWord)
        // Aserciones
        // Assert that current word is scrambled.
        assertNotEquals(unScrambledWord, gameUiState.currentScrambledWord)
        // Assert that current word count is set to 1.
        assertTrue(gameUiState.currentWordCount == 1)
        // Assert that initially the score is 0.
        assertTrue(gameUiState.score == 0)
        // Assert that the wrong word guessed is false.
        assertFalse(gameUiState.isGuessedWordWrong)
        // Assert that game is not over.
        assertFalse(gameUiState.isGameOver)
    }

    /**
     * Prueba para GameViewModel: Todas las Palabras Adivinadas - Actualización Correcta del Estado de la Interfaz de Usuario
     *
     * Esta prueba verifica que el `GameViewModel` actualice correctamente el estado de la interfaz de usuario del juego
     * cuando todas las palabras se han adivinado.
     */
    @Test
    fun gameViewModel_AllWordsGuessed_UiStateUpdatedCorrectly() {
        // Inicialización
        var expectedScore = 0
        var currentGameUiState = viewModel.uiState.value
        var correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)

        // Iterar por todas las palabras
        repeat(MAX_NO_OF_WORDS) {
            //Actualizar puntuación esperada
            expectedScore += SCORE_INCREASE
            // Simular adivinación correcta del jugador
            viewModel.updateUserGuess(correctPlayerWord)
            viewModel.checkUserGuess()
            //Obtener estado
            currentGameUiState = viewModel.uiState.value
            correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)
            // Assert that after each correct answer, score is updated correctly.
            assertEquals(expectedScore, currentGameUiState.score)
        }
        //Verificaciones finales
        // Assert that after all questions are answered, the current word count is up-to-date.
        assertEquals(MAX_NO_OF_WORDS, currentGameUiState.currentWordCount)
        // Assert that after 10 questions are answered, the game is over.
        assertTrue(currentGameUiState.isGameOver)
    }

    @Test
    fun gameViewModel_WordSkipped_ScoreUnchangedAndWordCountIncreased() {
        var currentGameUiState = viewModel.uiState.value
        val correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)
        viewModel.updateUserGuess(correctPlayerWord)
        viewModel.checkUserGuess()

        currentGameUiState = viewModel.uiState.value
        val lastWordCount = currentGameUiState.currentWordCount
        viewModel.skipWord()
        currentGameUiState = viewModel.uiState.value
        // Assert that score remains unchanged after word is skipped.
        assertEquals(SCORE_AFTER_FIRST_CORRECT_ANSWER, currentGameUiState.score)
        // Assert that word count is increased by 1 after word is skipped.
        assertEquals(lastWordCount + 1, currentGameUiState.currentWordCount)
    }
}