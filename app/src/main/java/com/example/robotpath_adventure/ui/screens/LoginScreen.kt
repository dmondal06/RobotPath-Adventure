package com.example.robotpath_adventure.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.wear.compose.material.MaterialTheme.colors
import com.example.robotpath_adventure.R

import com.example.robotpath_adventure.utils.ParentSession
@Composable
fun LoginScreen(navController: NavHostController) {
    var isParentLogin by remember { mutableStateOf(true) } // Toggle between Parent and Kid login
    var emailOrKidID by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Background",
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { isParentLogin = true },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isParentLogin) Color(0xFF00A1FF) else Color.Gray
                    ),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Parent Login", color = Color.White)
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = { isParentLogin = false },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (!isParentLogin) Color(0xFF00A1FF) else Color.Gray
                    ),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Kid Login", color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = emailOrKidID,
                onValueChange = { emailOrKidID = it },
                label = { Text(if (isParentLogin) "Email" else "Kid ID") },
                modifier = Modifier.fillMaxWidth()
            )

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (isParentLogin) {
                        navController.navigate("parent_dashboard")
                    } else {
                        navController.navigate("kid_dashboard")
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00A1FF)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Login", color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(
                onClick = { navController.navigate("registration") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Don't have an account? Sign up here.")
            }
        }
    }
}
