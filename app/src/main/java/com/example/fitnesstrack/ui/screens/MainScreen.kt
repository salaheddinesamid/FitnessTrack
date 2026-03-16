package com.example.fitnesstrack.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fitnesstrack.ui.components.Destination
import com.example.fitnesstrack.ui.components.NavBar
import com.example.fitnesstrack.ui.theme.FitnessTrackTheme

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold (
        bottomBar = {
            NavBar(navController = navController)
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = Destination.Home.route,
            modifier = Modifier.padding(padding)
        ) {

            composable(Destination.Home.route) {
                HomeScreen()
            }

            composable(Destination.Workout.route) {
                WorkoutScreen()
            }

            composable(Destination.HealthRecord.route){
                HealthRecordScreen()
            }

            composable(Destination.DietAndMeals.route){
                DietAndMealScreen()
            }
            composable(Destination.Profile.route){
                ProfileScreen()
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    FitnessTrackTheme() {
        MainScreen()
    }
}


