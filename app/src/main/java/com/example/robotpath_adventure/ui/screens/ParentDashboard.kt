package com.example.robotpath_adventure.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class Kid(val name: String, val kidID: String, val age: String)

@Composable
fun ParentDashboardScreen(navController: NavController) {
    var showAddKidForm by remember { mutableStateOf(false) }

    // Form fields
    var name by remember { mutableStateOf("") }
    var kidID by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // List to hold added kids
    var kidsList by remember { mutableStateOf<List<Kid>>(emptyList()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF8F9FA)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Screen Title
        Text(
            text = "My Kids",
            style = TextStyle(
                fontSize = 28.sp,
                color = Color(0xFF4CAF50),
                shadow = Shadow(Color.Gray, offset = androidx.compose.ui.geometry.Offset(1f, 1f), blurRadius = 2f)
            ),
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Display Kids List
        if (kidsList.isEmpty()) {
            Text(
                text = "No kids added yet!",
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.Gray),
                modifier = Modifier.padding(8.dp)
            )
        } else {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                kidsList.forEach { kid ->
                    KidCard(kid = kid)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Add Kid Button
        Button(
            onClick = { showAddKidForm = !showAddKidForm },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = if (showAddKidForm) "Close Form" else "+ Add a Kid",
                color = Color.White,
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Add Kid Form
        if (showAddKidForm) {
            AddKidForm(
                name = name,
                onNameChange = { name = it },
                kidID = kidID,
                onKidIDChange = { kidID = it },
                age = age,
                onAgeChange = { age = it },
                password = password,
                onPasswordChange = { password = it },
                onSubmit = {
                    // Add kid to the list
                    if (name.isNotEmpty() && kidID.isNotEmpty() && age.isNotEmpty()) {
                        kidsList = kidsList + Kid(name = name, kidID = kidID, age = age)
                        // Clear form fields
                        name = ""
                        kidID = ""
                        age = ""
                        password = ""
                        showAddKidForm = false
                    }
                }
            )
        }
    }
}

@Composable
fun AddKidForm(
    name: String,
    onNameChange: (String) -> Unit,
    kidID: String,
    onKidIDChange: (String) -> Unit,
    age: String,
    onAgeChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    onSubmit: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F1F1)),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextField(
                value = name,
                onValueChange = onNameChange,
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )

            TextField(
                value = kidID,
                onValueChange = onKidIDChange,
                label = { Text("Kid ID") },
                modifier = Modifier.fillMaxWidth()
            )

            TextField(
                value = age,
                onValueChange = onAgeChange,
                label = { Text("Age") },
                modifier = Modifier.fillMaxWidth()
            )

            TextField(
                value = password,
                onValueChange = onPasswordChange,
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onSubmit,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Add Kid", color = Color.White)
            }
        }
    }
}

@Composable
fun KidCard(kid: Kid) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF4CAF50)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = kid.name.first().uppercase(),
                    style = MaterialTheme.typography.headlineSmall.copy(color = Color.White)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(text = "Name: ${kid.name}", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Kid ID: ${kid.kidID}", style = MaterialTheme.typography.bodySmall)
                Text(text = "Age: ${kid.age}", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}
