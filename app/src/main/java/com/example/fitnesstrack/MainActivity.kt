package com.example.fitnesstrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fitnesstrack.services.AuthManager
import com.example.fitnesstrack.ui.screens.LoginScreen
import com.example.fitnesstrack.ui.screens.MainScreen
import com.example.fitnesstrack.ui.theme.FitnessTrackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitnessTrackTheme {
                val navController = rememberNavController()
                val authManager = AuthManager(this)

                val startDestination =
                    if (authManager.isLoggedIn())
                        "home"
                    else
                        "login"
                NavHost(
                    navController = navController,
                    startDestination = startDestination
                ) {

                    composable("login") {
                        LoginScreen(navController)
                    }

                    composable("main") {
                        MainScreen()
                    }
                }
            }
        }
    }
}