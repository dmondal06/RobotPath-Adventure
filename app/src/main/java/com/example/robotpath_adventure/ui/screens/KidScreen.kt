package com.example.robotpath_adventure.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.robotpath_adventure.ViewModels.KidViewModel
import com.example.robotpath_adventure.data.Kid
import com.example.robotpath_adventure.utils.ParentSession
//
//@Composable
//fun KidScreen(viewModel: KidViewModel, navController: NavController) {
//
//    // Collect kids list from ViewModel
//   // val kidsList by viewModel.kidsList.collectAsState()
//    var showAddKidForm by remember { mutableStateOf(false) }
//
//    // Form fields
//    var name by remember { mutableStateOf("") }
//    var kidID by remember { mutableStateOf("") }
//    var age by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//
//    if (ParentSession.email == null) {
//        // If email is null, show an error or redirect
//        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//            Text(text = "Parent email not set. Please log in.", color = Color.Red)
//        }
//    } else {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//            verticalArrangement = Arrangement.Top,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            // Screen Title
//            Text(
//                text = "My Kids",
//                style = MaterialTheme.typography.headlineMedium,
//                modifier = Modifier.align(Alignment.Start)
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Kids List
//            if (kidsList.isEmpty()) {
//                Text(
//                    text = "No kids added yet!",
//                    style = MaterialTheme.typography.bodyLarge,
//                    color = Color.Gray,
//                    modifier = Modifier.padding(8.dp)
//                )
//            } else {
//                kidsList.forEach { kid ->
//                    KidItem(kid = kid) {
//                        println("Kid clicked: ${kid.name}")
//                    }
//                }
//            }
//
//            // Add Kid Button
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(50.dp)
//                    .padding(8.dp)
//                    .background(Color.LightGray)
//                    .clickable { showAddKidForm = !showAddKidForm },
//                contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    text = if (showAddKidForm) "Close Form" else "+ Add a Kid",
//                    style = MaterialTheme.typography.bodyLarge,
//                    color = Color.Black
//                )
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Add Kid Form
//            if (showAddKidForm) {
//                AddKidForm(
//                    name = name,
//                    onNameChange = { name = it },
//                    kidID = kidID,
//                    onKidIDChange = { kidID = it },
//                    age = age,
//                    onAgeChange = { age = it },
//                    password = password,
//                    onPasswordChange = { password = it },
//                    onSubmit = {
//                        val email = ParentSession.email
//                        if (email != null) {
//                            viewModel.addKid(
//                                Kid(
//                                    email = email,
//                                    name = name,
//                                    kidID = kidID,
//                                    age = age.toInt(),
//                                    password = password
//                                )
//                            )
//                            // Reset the form fields
//                            name = ""
//                            kidID = ""
//                            age = ""
//                            password = ""
//                            showAddKidForm = false
//                        } else {
//                            println("Error: Parent email is null. Cannot add kid.")
//                        }
//                    }
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun KidItem(kid: Kid, onClick: () -> Unit) {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(100.dp)
//            .padding(8.dp)
//            .background(Color.Cyan)
//            .clickable { onClick() },
//        contentAlignment = Alignment.Center
//    ) {
//        Text(
//            text = kid.name,
//            style = MaterialTheme.typography.headlineSmall,
//            color = Color.Black
//        )
//    }
//}
//
//@Composable
//fun AddKidForm(
//    name: String,
//    onNameChange: (String) -> Unit,
//    kidID: String,
//    onKidIDChange: (String) -> Unit,
//    age: String,
//    onAgeChange: (String) -> Unit,
//    password: String,
//    onPasswordChange: (String) -> Unit,
//    onSubmit: () -> Unit
//) {
//    Column(
//        modifier = Modifier.fillMaxWidth(),
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        TextField(
//            value = name,
//            onValueChange = onNameChange,
//            label = { Text("Name") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        TextField(
//            value = kidID,
//            onValueChange = onKidIDChange,
//            label = { Text("Kid ID") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        TextField(
//            value = age,
//            onValueChange = onAgeChange,
//            label = { Text("Age") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        TextField(
//            value = password,
//            onValueChange = onPasswordChange,
//            label = { Text("Password") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = onSubmit,
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text("Add Kid")
//        }
//    }
//}
