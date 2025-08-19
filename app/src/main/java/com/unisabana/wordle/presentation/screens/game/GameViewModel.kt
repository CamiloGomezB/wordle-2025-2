package com.unisabana.wordle.presentation.screens.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.unisabana.wordle.data.getRandomWord

class GameViewModel: ViewModel() {

    // attribute

    var solution by mutableStateOf(getRandomWord())
        private set
    var currentWord by mutableStateOf("")
        private set
    var attemps by mutableStateOf(listOf<String>())
        private set
    var score by mutableIntStateOf(0)

    // func

    fun onKeyPressed(letter:Char) {

        if (currentWord.length < 5 ) {
            currentWord += letter
        }
    }

    fun onSubmit () {

        // To check the word

        if ( currentWord.length == 5 ) {
            attemps = attemps + currentWord
            currentWord = ""
        }

    }

    fun onRemoveLetter () {
        if ( !currentWord.isEmpty()) {
            currentWord.dropLast(1)
        }
    }

    fun resetGame () {
        attemps = emptyList()
        solution = getRandomWord()
        currentWord = ""
    }
}