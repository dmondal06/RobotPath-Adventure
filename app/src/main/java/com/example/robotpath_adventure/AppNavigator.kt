package com.example.robotpath_adventure

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.robotpath_adventure.ui.LoginScreen
import com.example.robotpath_adventure.ui.screens.*

@Composable
fun AppNavigator() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        // Splash Screen
        composable("splash") {
            SplashScreen(navController = navController)
        }

        // Login Screen
        composable("login") {
            LoginScreen(navController = navController)
        }

        // Registration Screen
        composable("registration") {
            RegistrationScreen(navController = navController)
        }

        // Parent Dashboard Screen
        composable("parent_dashboard") {
            ParentDashboardScreen(navController = navController)
        }

        // Kid Dashboard Screen
        composable("kid_dashboard") {
            KidDashboardScreen(navController = navController)
        }

        // Game Screen
        composable("number_puzzle_game") {
            NumberPuzzleGameScreen(navController = navController)
        }

        // Dashboard Screen (Placeholder for any shared dashboard logic)
        composable("dashboard") {
            DashboardScreen(navController = navController)
        }

    }
}
