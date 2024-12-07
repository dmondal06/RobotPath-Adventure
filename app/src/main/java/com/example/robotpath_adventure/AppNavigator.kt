package com.example.robotpath_adventure



import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.robotpath_adventure.ViewModels.LoginViewModel
import com.example.robotpath_adventure.data.AppDatabase
import com.example.robotpath_adventure.data.UserRepository
import com.example.robotpath_adventure.ui.LoginScreen
import com.example.robotpath_adventure.ui.screens.RegistrationScreen
import com.example.robotpath_adventure.ui.screens.SplashScreen

@Composable
fun AppNavigator(appDatabase: AppDatabase) {
    val navController: NavHostController = rememberNavController()
    val userRepository = UserRepository(appDatabase.userDao())
    val loginViewModel: LoginViewModel = viewModel(factory = LoginViewModel.provideFactory(userRepository))

    NavHost(navController = navController, startDestination = "splash") {
        // Splash Screen
        composable("splash") {
            SplashScreen(navController)
        }

        // Login Page
        composable("login") {
            LoginScreen(navController = navController,viewModel = loginViewModel)
        }

        // Registration Page
        composable("registration") {
            RegistrationScreen(navController)
        }

        // Dashboard
        composable("dashboard") {
            DashboardScreen(navController)
        }

    }
}



@Composable
fun DashboardScreen(navController: NavHostController) {

}
