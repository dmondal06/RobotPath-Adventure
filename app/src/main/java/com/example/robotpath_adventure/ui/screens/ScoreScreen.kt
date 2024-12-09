package com.example.robotpath_adventure.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.robotpath_adventure.R

@Composable
fun ScoreScreen(navController: NavHostController, level: String, moves: Int, score: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF8E44AD), Color(0xFF3498DB))
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White.copy(alpha = 0.9f))
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title
            Text(
                text = if (score > 0) "YOU WIN!" else "GAME OVER!",
                style = MaterialTheme.typography.headlineMedium.copy(fontSize = 28.sp),
                color = if (score > 0) Color(0xFF2ECC71) else Color(0xFFE74C3C),
                modifier = Modifier.padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )

            // Stars (only for winning)
            if (score > 0) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(16.dp)
                ) {
                    repeat(3) {
                        Icon(
                            painter = painterResource(id = R.drawable.star), // Use your star drawable
                            contentDescription = "Star Icon",
                            tint = Color(0xFFFFD700),
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Score Display
            Text(
                text = "Score: $score",
                style = MaterialTheme.typography.headlineSmall.copy(fontSize = 24.sp),
                color = Color.Black
            )

            // Moves Display
            Text(
                text = "Moves: $moves",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp),
                color = Color.DarkGray,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Buttons for Dashboard and Replay
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Back to Dashboard Button
                Button(
                    onClick = { navController.navigate("kid_dashboard") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3498DB)),
                    modifier = Modifier.weight(1f).padding(end = 8.dp)
                ) {
                    Text(text = "Dashboard", color = Color.White)
                }

                // Play Again Button
                Button(
                    onClick = { navController.navigate("number_puzzle_game") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2ECC71)),
                    modifier = Modifier.weight(1f).padding(start = 8.dp)
                ) {
                    Text(text = "Play Again", color = Color.White)
                }
            }
        }
    }
}
