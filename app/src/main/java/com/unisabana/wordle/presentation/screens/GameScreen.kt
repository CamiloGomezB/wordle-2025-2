package com.unisabana.wordle.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun GameScreen(){
    Scaffold {
            innerPadding ->
        Column (modifier = Modifier.padding(innerPadding)){
            Text("Hola Game", )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGameScreen(){
    GameScreen()
}