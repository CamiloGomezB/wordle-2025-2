package com.unisabana.wordle.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun GameScreen(){
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

                repeat(7){
                    Row ( horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        repeat(5) {
                            Cell("" , CellType.TRANSPARENT)
                        }
                    }
                }
            }
        }
    
    }

@Preview(showBackground = true)
@Composable
fun PreviewGameScreen(){
    GameScreen()
}

@Composable
fun CellAll() {
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
fun PreviewCellSuccess(){
    Column {
        Row{
            Cell("H", CellType.GREEN)
            Cell("E", CellType.GREY)
            Cell("L", CellType.YELLOW)
            Cell("L", CellType.GREEN)
            Cell("O", CellType.TRANSPARENT)
        }

        Row{
            Cell(" ", CellType.TRANSPARENT)
            Cell(" ", CellType.TRANSPARENT)
            Cell(" ", CellType.TRANSPARENT)
            Cell(" ", CellType.TRANSPARENT)
            Cell(" ", CellType.TRANSPARENT)
        }
    }
}