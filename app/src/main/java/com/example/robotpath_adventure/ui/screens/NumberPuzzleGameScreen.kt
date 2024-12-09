package com.example.robotpath_adventure.ui.screens



import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun NumberPuzzleGameScreen(navController: NavController) {
    var level by remember { mutableStateOf<Int?>(null) }
    val gridSize = when (level) {
        1 -> 3 // Easy
        2 -> 4 // Medium
        3 -> 5 // Hard
        else -> null
    }

    if (level == null) {
        LevelSelectionScreen(onLevelSelected = { selectedLevel -> level = selectedLevel })
    } else {
        PuzzleScreen(gridSize = gridSize!!, onRestart = { level = null }, onExit = { navController.popBackStack() })
    }
}

@Composable
fun LevelSelectionScreen(onLevelSelected: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Select Difficulty", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { onLevelSelected(1) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Easy (3x3)")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onLevelSelected(2) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Medium (4x4)")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onLevelSelected(3) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Hard (5x5)")
        }
    }
}

@Composable
fun PuzzleScreen(gridSize: Int, onRestart: () -> Unit, onExit: () -> Unit) {
    var numbers by remember { mutableStateOf((1..(gridSize * gridSize)).shuffled().toMutableList()) }
    val grid = numbers.chunked(gridSize)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Number Puzzle Game (${gridSize}x${gridSize})",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Puzzle Grid
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            grid.forEach { row ->
                Row(
                    modifier = Modifier.padding(4.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    row.forEach { number ->
                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .background(Color.LightGray, RoundedCornerShape(8.dp))
                                .padding(8.dp)
                                .clickable {
                                    // Logic for swapping tiles will go here
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = number.toString(),
                                fontSize = 18.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Buttons
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = onRestart) {
                Text("Restart")
            }

            Button(onClick = onExit) {
                Text("Exit")
            }
        }
    }
}
