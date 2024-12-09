package com.example.robotpath_adventure.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.robotpath_adventure.R

@Composable
fun KidDashboardScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.kiddb), // Replace with your background resource
            contentDescription = "Kid Dashboard Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Transparent clickable area for the "Play" button
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            // Button at the "Play" position
            Box(
                modifier = Modifier
                    .size(400.dp, 100.dp) // Adjust the size and position to match the "Play" area
                    .offset(y = 350.dp) // Adjust this to match the vertical position of the "Play" button in the background
                    .clickable {
                        navController.navigate("number_puzzle_game")
                    }
            )
        }
    }
}
