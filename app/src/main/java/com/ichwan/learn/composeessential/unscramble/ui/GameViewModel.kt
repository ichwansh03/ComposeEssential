package com.ichwan.learn.composeessential.unscramble.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.ichwan.learn.composeessential.unscramble.data.MAX_NO_OF_WORDS
import com.ichwan.learn.composeessential.unscramble.data.SCORE_INCREASE
import com.ichwan.learn.composeessential.unscramble.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    var userGuess by mutableStateOf("")
        private set

    private var userWords: MutableSet<String> = mutableSetOf()
    private lateinit var currentWord: String

    fun resetGame() {
        userWords.clear()
        _uiState.value = GameUiState(currentScrambledWord = pickRandomWordAndShuffle())
    }

    fun updateUserGuess(guess: String) {
        userGuess = guess
    }

    fun checkUserGuess() {
        if (userGuess.equals(currentWord, ignoreCase = true)) {
            val updatedScore = _uiState.value.score.plus(SCORE_INCREASE)
            updateGameState(updatedScore)
        } else {
            _uiState.update {
                it.copy(isGuessedWordWrong = true)
            }
        }

        updateUserGuess("")
    }

    private fun updateGameState(updatedScore: Int) {
        if (userWords.size == MAX_NO_OF_WORDS) {
            _uiState.update {
                it.copy(
                    isGuessedWordWrong = false,
                    score = updatedScore,
                    isGameOver = true
                )
            }
        } else {
            _uiState.update {
                it.copy(isGuessedWordWrong = false,
                    currentWordCount = it.currentWordCount.inc(),
                    currentScrambledWord = pickRandomWordAndShuffle(),
                    score = updatedScore)
            }
        }
    }

    private fun shuffleCurrentWord(word: String): String {
        val shuffledWord = word.toCharArray()
        shuffledWord.shuffle()

        while (String(shuffledWord) == word) {
            shuffledWord.shuffle()
        }
        return String(shuffledWord)
    }

    private fun pickRandomWordAndShuffle(): String {
        currentWord = allWords.random()
        return if (userWords.contains(currentWord)) {
            pickRandomWordAndShuffle()
        } else {
            return shuffleCurrentWord(currentWord)
        }
    }

    fun skipWord() {
        updateGameState(_uiState.value.score)
        updateUserGuess("")
    }
}