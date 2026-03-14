package com.example.fitnesstrack

sealed class NavigationScreen (val route : String) {
    object Login : NavigationScreen("login")
    object Register : NavigationScreen("register")
    object Home : NavigationScreen("home")
    object HealthRecord : NavigationScreen("health_record")
    object DietPlan : NavigationScreen("diet_plan")
    object ExercisePlan : NavigationScreen("exercise_plan")
    object Profile : NavigationScreen("profile")
}