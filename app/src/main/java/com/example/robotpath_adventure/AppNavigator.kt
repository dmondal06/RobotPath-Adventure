package com.example.robotpath_adventure

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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

        composable("dashboard") {
            DashboardScreen(navController = navController)
        }

        // Define score_screen to accept level and moves as parameters
        composable(
            route = "score_screen/{level}/{moves}/{score}",
            arguments = listOf(
                navArgument("level") { type = NavType.StringType },
                navArgument("moves") { type = NavType.IntType },
                navArgument("score") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val level = backStackEntry.arguments?.getString("level") ?: "easy"
            val moves = backStackEntry.arguments?.getInt("moves") ?: 0
            val score = backStackEntry.arguments?.getInt("score") ?: 0
            ScoreScreen(navController = navController, level = level, moves = moves, score = score)
        }


    }
}
