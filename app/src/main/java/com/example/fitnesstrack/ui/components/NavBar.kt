package com.example.fitnesstrack.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fitnesstrack.ui.screens.HomeScreen
import com.example.fitnesstrack.ui.screens.WorkoutScreen
import com.example.fitnesstrack.ui.theme.FitnessTrackTheme


enum class Destination(
    val route : String,
    val label : String,
){
    Home("home", "Home"),
    Workout("workout", "Workout"),
    Diet("diet", "Diet"),
    Profile("profile", "Profile")
}
@Composable
fun NavBar(
    navController : NavController,
    startDestination : Destination = Destination.Home
){
    NavHost(
        navController as NavHostController,
        startDestination = startDestination.route
    ){
        Destination.entries.forEach {
                destination -> composable(destination.route){
            when (destination) {
                Destination.Home -> HomeScreen()
                Destination.Workout -> WorkoutScreen()
                else -> {}
            }
        }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun NavBarPreview(){
    FitnessTrackTheme() {
        NavBar(
            navController = NavController(LocalContext.current)
        )
    }
}