package com.example.robotpath_adventure

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.robotpath_adventure.data.DatabaseProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the AppDatabase
        val appDatabase = DatabaseProvider.getDatabase(applicationContext)

        setContent {
            // Set up the AppNavigator and pass the database
            AppNavigator(appDatabase = appDatabase)
        }
    }
}

//
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    RobotPathAdventureTheme {
//
//    }
//}