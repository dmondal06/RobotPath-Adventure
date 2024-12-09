package com.example.robotpath_adventure.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ParentDashboardScreen(navController: NavController) {
    var showAddKidForm by remember { mutableStateOf(false) }

    // Form fields
    var name by remember { mutableStateOf("") }
    var kidID by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Screen Title
        Text(
            text = "Parent Dashboard - My Kids",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Placeholder for Kids List
        // Replace this with dynamic content if needed
        Text(
            text = "No kids added yet!",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray,
            modifier = Modifier.padding(8.dp)
        )

        // Add Kid Button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(8.dp)
                .background(Color.LightGray)
                .clickable { showAddKidForm = !showAddKidForm },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (showAddKidForm) "Close Form" else "+ Add a Kid",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black
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
                    // Add your logic for adding a kid here
                    name = ""
                    kidID = ""
                    age = ""
                    password = ""
                    showAddKidForm = false
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
    Column(
        modifier = Modifier.fillMaxWidth(),
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
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Kid")
        }
    }
}
