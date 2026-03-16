package com.example.fitnesstrack.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fitnesstrack.ui.components.Destination
import com.example.fitnesstrack.ui.components.NavBar
import com.example.fitnesstrack.ui.theme.FitnessTrackTheme

@Composable
fun HomeScreen() {

    Text(
        text = "Home Screen",
        modifier = Modifier.padding(16.dp)
    )

}

@Composable
fun Greeting(name : String){
    Text(text = "Hello $name!")
}

@Composable
fun ExercisesComposable(){

}

@Preview
@Composable
fun HomeScreenPreview(){
    FitnessTrackTheme {
        HomeScreen()
    }
}