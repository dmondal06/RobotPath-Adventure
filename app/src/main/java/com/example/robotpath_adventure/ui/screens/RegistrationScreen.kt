package com.example.robotpath_adventure.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.robotpath_adventure.ViewModels.RegistrationState
import com.example.robotpath_adventure.ViewModels.RegistrationViewModel


@Composable
fun RegistrationScreen(navController: NavHostController) {
    // Obtain the ViewModel instance
    val registrationViewModel: RegistrationViewModel = viewModel()
    val registrationState by registrationViewModel.registrationState.collectAsState()

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var role by remember { mutableStateOf("kid") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = { role = "kid" }) { Text("Kid") }
            Button(onClick = { role = "parent" }) { Text("Parent") }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { registrationViewModel.registerUser(name, email, password, role) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Register")
        }

        when (registrationState) {
            is RegistrationState.Success -> navController.navigate("login") {
                popUpTo("registration") { inclusive = true }
            }
            is RegistrationState.Error -> Text((registrationState as RegistrationState.Error).message, color = MaterialTheme.colorScheme.error)
            else -> {}
        }
    }
}
