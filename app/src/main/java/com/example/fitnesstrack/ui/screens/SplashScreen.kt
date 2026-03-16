package com.example.fitnesstrack.ui.screens

import android.window.SplashScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnesstrack.ui.theme.FitnessBlue
import com.example.fitnesstrack.ui.theme.FitnessTrackTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController : NavController
){
    LaunchedEffect (Unit) {
        delay(2000) // 2 seconds
        navController.navigate("login") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize().background(FitnessBlue),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "FitnessTrack 💪",
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}
@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    FitnessTrackTheme() {
        SplashScreen(rememberNavController())
    }
}