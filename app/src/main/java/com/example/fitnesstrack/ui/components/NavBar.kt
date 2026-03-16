package com.example.fitnesstrack.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.MonitorHeart

import androidx.compose.material.icons.filled.NoMeals
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.fitnesstrack.ui.theme.FitnessTrackTheme

sealed class Destination(val route: String) {
    object Home    : Destination("home")
    object Workout : Destination("workout")
    object HealthRecord : Destination("health_record")
    object DietAndMeals : Destination("diets")
    object Profile : Destination("profile")
}

data class NavItem(
    val label: String,
    val destination: Destination,
    val icon: ImageVector
)

val navItems = listOf(
    NavItem("Home",    Destination.Home,    Icons.Default.Home),
    NavItem("Workout", Destination.Workout, Icons.Default.FitnessCenter),
    NavItem("Health", Destination.HealthRecord, Icons.Default.MonitorHeart),
    NavItem("Diets", Destination.DietAndMeals, Icons.Default.NoMeals),
    NavItem("Profile", Destination.Profile, Icons.Default.Person),
)

@Composable
fun NavBar(navController: NavController) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    NavigationBar {
        navItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.destination.route,
                onClick = {
                    navController.navigate(item.destination.route) {
                        popUpTo(Destination.Home.route) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) }
            )
        }
    }
}

@Preview
@Composable
fun NavBarPreview() {
    FitnessTrackTheme {
        // Simulate what NavBar looks like with "Home" selected
        NavigationBar {
            navItems.forEach { item ->
                NavigationBarItem(
                    selected = item.destination == Destination.Home,
                    onClick = {},
                    icon = { Icon(item.icon, contentDescription = item.label) },
                    label = { Text(item.label) }
                )
            }
        }
    }
}