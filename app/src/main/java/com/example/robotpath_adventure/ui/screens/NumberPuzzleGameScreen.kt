package com.example.robotpath_adventure.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.robotpath_adventure.R
import kotlin.math.absoluteValue

@Composable
fun NumberPuzzleGameScreen(navController: NavHostController) {
    // Game states
    var gridSize by remember { mutableStateOf(3) } // 3x3 grid
    var tiles by remember { mutableStateOf(generateShuffledTiles(gridSize)) }
    var moves by remember { mutableStateOf(0) }
    var isGameWon by remember { mutableStateOf(false) }
    var score by remember { mutableStateOf(0) }

    // Check for win condition
    LaunchedEffect(tiles) {
        if (tiles == generateCorrectTiles(gridSize)) {
            isGameWon = true
            score = calculateScore(gridSize) // Calculate score only if the level is completed
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF0F2027), Color(0xFF203A43), Color(0xFF2C5364))
                )
            )
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.game),
            contentDescription = "Game Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Number Puzzle",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Moves: $moves",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Puzzle Grid
            GridLayout(gridSize = gridSize, tiles = tiles) { tileIndex ->
                val emptyIndex = tiles.indexOf(0)
                if (isAdjacent(tileIndex, emptyIndex, gridSize)) {
                    // Swap tiles
                    tiles = tiles.toMutableList().apply {
                        this[emptyIndex] = this[tileIndex]
                        this[tileIndex] = 0
                    }
                    moves++
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Exit Game Button
            Button(
                onClick = {
                    val finalScore = if (isGameWon) score else 0 // If game is not won, score is 0
                    navController.navigate("score_screen/${getLevelName(gridSize)}/$moves/$finalScore")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFd32f2f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Exit Game", color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Next Level or Restart
            if (isGameWon) {
                Button(
                    onClick = {
                        moves = 0
                        isGameWon = false
                        gridSize = getNextLevel(gridSize) // Move to the next level
                        tiles = generateShuffledTiles(gridSize)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00A1FF))
                ) {
                    Text(text = if (gridSize == 5) "Restart Game" else "Next Level", color = Color.White)
                }
            }
        }
    }
}

// Function to calculate score
fun calculateScore(gridSize: Int): Int {
    return when (gridSize) {
        3 -> 100 // Easy
        4 -> 200 // Medium
        5 -> 300 // Hard
        else -> 0 // Default
    }
}

// Function to check if two tiles are adjacent
fun isAdjacent(index1: Int, index2: Int, gridSize: Int): Boolean {
    val row1 = index1 / gridSize
    val col1 = index1 % gridSize
    val row2 = index2 / gridSize
    val col2 = index2 % gridSize

    return (row1 == row2 && (col1 - col2).absoluteValue == 1) ||
            (col1 == col2 && (row1 - row2).absoluteValue == 1)
}

// Function to generate a shuffled tile grid
fun generateShuffledTiles(gridSize: Int): List<Int> {
    val tiles = generateCorrectTiles(gridSize).toMutableList()
    tiles.shuffle()
    return tiles
}

// Function to generate the correct tile order for the grid
fun generateCorrectTiles(gridSize: Int): List<Int> {
    return (1 until gridSize * gridSize).toList() + listOf(0)
}

// Function to get the next level grid size
fun getNextLevel(currentSize: Int): Int {
    return when (currentSize) {
        3 -> 4 // Easy -> Medium
        4 -> 5 // Medium -> Hard
        else -> 3 // Hard -> Restart to Easy
    }
}

// Function to get the level name
fun getLevelName(gridSize: Int): String {
    return when (gridSize) {
        3 -> "easy"
        4 -> "medium"
        5 -> "hard"
        else -> "easy"
    }
}

// Composable for the grid layout
@Composable
fun GridLayout(gridSize: Int, tiles: List<Int>, onTileClick: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White.copy(alpha = 0.8f))
            .padding(16.dp)
    ) {
        for (row in 0 until gridSize) {
            Row(modifier = Modifier.fillMaxWidth()) {
                for (col in 0 until gridSize) {
                    val index = row * gridSize + col
                    val tile = tiles[index]
                    Tile(tile = tile, onClick = { onTileClick(index) })
                }
            }
        }
    }
}

// Composable for a single tile
@Composable
fun Tile(tile: Int, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(80.dp)
            .background(if (tile == 0) Color.LightGray else Color(0xFF4CAF50))
            .clickable(enabled = tile != 0) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        if (tile != 0) {
            Text(
                text = tile.toString(),
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
        }
    }
}
