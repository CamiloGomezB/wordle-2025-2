package com.unisabana.wordle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController   // 👈 import
import com.unisabana.wordle.presentation.screens.game.GameScreen
import com.unisabana.wordle.ui.theme.WordleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            WordleTheme {
                val navController = rememberNavController() // 👈 crear NavController
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GameScreen(navController = navController) // 👈 pasarlo a tu pantalla
                }
            }
        }
    }
}
