package com.unisabana.wordle.presentation.screens.game

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

private val CellSize: Dp = 50.dp
private val CellGap: Dp = 4.dp
private const val Cols: Int = 5
private val BoardWidth: Dp = CellSize * Cols + CellGap * (Cols - 1)


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun GameScreen(
    navController: NavHostController,
    gameViewModel: GameViewModel = viewModel()
) {
    Scaffold (
        containerColor = Color(0xFF000000),
        topBar= {
            CenterAlignedTopAppBar(
                title = { Text("WORDLE")},
                navigationIcon = {
                    IconButton(onClick = { }){
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Atras"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }){
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "Más opciones"
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF1E1E1E),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        },

        )       {
            innerPadding ->
        Column (modifier     = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(innerPadding)
            .padding(top = 55.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {

            repeat(6){
                Row ( horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    repeat(5) {
                        Cell("" , CellType.TRANSPARENT)
                    }
                }
            }

            Keyboard(
                modifier = Modifier
                    .width(BoardWidth)
                    .align(Alignment.CenterHorizontally),
                gameViewModel::onRemoveLetter,
                gameViewModel::onKeyPressed

            )

            Button(
                onClick = { },
                modifier = Modifier
                    .width(BoardWidth)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 8.dp)
                    .height(46.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6AAA65),
                    contentColor = Color.White
                )
            ) {
                Text("ENVIAR")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewGameScreen(){
    val navController = rememberNavController()
    GameScreen(navController)
}
enum class CellType{
    GREEN,
    YELLOW,
    GREY,
    TRANSPARENT
}

@Composable
fun Cell(character: String, blockType:CellType){

    val backgroundColor = when (blockType){
        CellType.YELLOW -> Color(0xFFC9B457)
        CellType.GREEN -> Color(0xFF6AAA65)
        CellType.GREY -> Color(0xFF787C7F)
        else -> Color.Transparent
    }

    Box(
        modifier = Modifier
            .size(50.dp)
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(2.dp))
            .background(backgroundColor, shape = RoundedCornerShape(2.dp)),
        contentAlignment = Alignment.Center
    ) { // -> Container -> div
        Text(character, fontSize = 26.sp, color = Color.White) // dp -> sp
    }
}

@Composable
private fun Keyboard( modifier: Modifier = Modifier,
                      onRemove: () -> Unit,
                      onKeyPressed: (Char) -> Unit) {
    val row1 = "QWERTYUIOP".toList()
    val row2 = "ASDFGHJKL".toList()
    val row3 = "ZXCVBNM⌫".toList()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Fila 1
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            row1.forEach { KeyButton(it.toString(), Modifier.weight(1f)) }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Spacer(Modifier.weight(0.5f))
            row2.forEach { KeyButton(it.toString(), Modifier.weight(1f)) }
            Spacer(Modifier.weight(0.5f))
        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            row3.forEach { KeyButton(it.toString(), Modifier.weight(1f)) }
            DeleteKey(Modifier.weight(1.5f))
        }
    }
}

@Composable
private fun KeyButton(text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = { },
        modifier = modifier.height(42.dp),
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF3A3A3C),
            contentColor = Color.White
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(text)
    }
}

@Composable
private fun DeleteKey(modifier: Modifier = Modifier) {
    Button(
        onClick = { },
        modifier = modifier.height(42.dp),
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF3A3A3C),
            contentColor = Color.White
        )
    ) {

    }
}

