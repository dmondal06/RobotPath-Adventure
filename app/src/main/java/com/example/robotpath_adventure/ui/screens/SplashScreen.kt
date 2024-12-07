package com.example.robotpath_adventure.ui.screens



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.robotpath_adventure.R
import kotlinx.coroutines.delay
import androidx.compose.runtime.LaunchedEffect

@Composable
fun SplashScreen(navController: NavHostController) {
    // Launch effect to navigate after a delay
    LaunchedEffect(Unit) {
        delay(3000) // 3-second delay
        navController.navigate("login") // Navigate to login screen
    }


    Image(
        painter = painterResource(id = R.drawable.robopath),
        contentDescription = "Splash Screen",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}
