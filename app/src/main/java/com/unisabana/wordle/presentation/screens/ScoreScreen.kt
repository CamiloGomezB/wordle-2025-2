@file:OptIn(ExperimentalMaterial3Api::class)

package com.unisabana.wordle.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ScoreEntry(val name: String, val score: Int)

@Composable
fun ScoreScreen(
    scores: List<ScoreEntry>,
    onBack: () -> Unit = {}
) {
    val bg = Color(0xFF121213)

    Scaffold(
        containerColor = bg,
        topBar = {
            TopAppBar(
                title = { Text("Leaderboard", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = bg,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { inner ->
        Box(
            modifier = Modifier
                .padding(inner)
                .fillMaxSize()
                .background(bg),
            contentAlignment = Alignment.Center // 🔹 Centrado vertical y horizontal
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val sorted = scores.sortedByDescending { it.score }
                sorted.forEachIndexed { index, item ->
                    val position = index + 1
                    Text(
                        text = "$position. ${item.name} - ${item.score}",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(vertical = 6.dp)
                    )
                }
            }
        }
    }
}

/* ---------- Preview con datos de ejemplo ---------- */

@Preview(showBackground = true, backgroundColor = 0xFF121213)
@Composable
fun PreviewScoreScreen() {
    val demo = listOf(
        ScoreEntry("Name one", 120),
        ScoreEntry("Name two", 115),
        ScoreEntry("Name one", 110),
        ScoreEntry("Name two", 108),
        ScoreEntry("Name one", 100),
        ScoreEntry("Name two", 95),
        ScoreEntry("Name one", 90),
        ScoreEntry("Name two", 88),
    )
    ScoreScreen(scores = demo)
}