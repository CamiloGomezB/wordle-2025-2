package com.unisabana.wordle.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unisabana.wordle.presentation.components.Cell
import com.unisabana.wordle.presentation.components.CellType

/* ======================= HOME ======================= */

@Composable
fun HomeScreen(
    onPlayClick: () -> Unit = {},
    onLeaderboardClick: () -> Unit = {}
) {
    val bg = Color(0xFF121213)
    val cardBg = Color(0xFF1A1A1B)

    Scaffold(containerColor = bg) { inner ->
        Column(
            modifier = Modifier
                .padding(inner)
                .fillMaxSize()
                .background(bg)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            WordleTitle()

            Spacer(Modifier.height(24.dp))

            HowToPlayCard(containerColor = cardBg)

            Spacer(Modifier.height(32.dp))

            // Botones
            Button(
                onClick = onPlayClick,
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .height(40.dp)
            ) { Text("Let's play!") }

            Spacer(Modifier.height(12.dp))

            OutlinedButton(
                onClick = onLeaderboardClick,
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .height(40.dp)
            ) { Text("Leaderboard") }
        }
    }
}

@Composable
private fun WordleTitle() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Cell("W", CellType.GREEN)
        Spacer(Modifier.width(4.dp))
        Cell("O", CellType.YELLOW)
        Spacer(Modifier.width(4.dp))
        Cell("R", CellType.GREY)
        Spacer(Modifier.width(4.dp))
        Cell("D", CellType.GREEN)
        Spacer(Modifier.width(4.dp))
        Cell("L", CellType.YELLOW)
        Spacer(Modifier.width(4.dp))
        Cell("E", CellType.GREY)
    }
}

@Composable
private fun HowToPlayCard(containerColor: Color) {
    Card(colors = CardDefaults.cardColors(containerColor)) {
        Column(Modifier.padding(16.dp)) {
            Text("How to play", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.height(8.dp))
            Bullet("Guess the Wordle in 6 tries.")
            Bullet("Each guess must be a valid 5-letter word.")
            Bullet("The color of the tiles will show how close your guess was.")

            Spacer(Modifier.height(16.dp))
            Text("Examples", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.height(12.dp))

            ExampleRow(
                listOf('W' to CellType.GREEN, 'O' to CellType.GREY, 'R' to CellType.GREY, 'D' to CellType.GREY, 'Y' to CellType.GREY),
                "W is in the word and in the correct spot."
            )
            Spacer(Modifier.height(10.dp))
            ExampleRow(
                listOf('L' to CellType.GREY, 'I' to CellType.YELLOW, 'G' to CellType.GREY, 'H' to CellType.GREY, 'T' to CellType.GREY),
                "I is in the word but in the wrong spot."
            )
            Spacer(Modifier.height(10.dp))
            ExampleRow(
                listOf('R' to CellType.GREY, 'O' to CellType.GREY, 'G' to CellType.GREY, 'U' to CellType.GREY, 'E' to CellType.GREY),
                "U is not in the word in any spot."
            )
        }
    }
}

@Composable private fun Bullet(text: String) {
    Row(Modifier.padding(bottom = 6.dp)) {
        Text("•", color = Color.White, fontSize = 16.sp)
        Spacer(Modifier.width(8.dp))
        Text(text, color = Color(0xFFE6E6E6), fontSize = 14.sp, lineHeight = 18.sp)
    }
}

@Composable private fun ExampleRow(
    word: List<Pair<Char, CellType>>,
    explanation: String
) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            word.forEachIndexed { i, (ch, type) ->
                Cell(ch.toString(), type)
                if (i != word.lastIndex) Spacer(Modifier.width(4.dp))
            }
        }
        Spacer(Modifier.height(6.dp))
        Text(explanation, color = Color(0xFFBDBDBD), fontSize = 13.sp)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF121213)
@Composable
private fun PreviewHome() {
    HomeScreen()
}