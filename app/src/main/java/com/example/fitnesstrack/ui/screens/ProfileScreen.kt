package com.example.fitnesstrack.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fitnesstrack.R
import com.example.fitnesstrack.ui.components.Swipeable
import com.example.fitnesstrack.ui.theme.FitnessTrackTheme

data class Item(
    val title: String,
    val subtitle: String
)

val meals = listOf(
    Item("Oatmeal & Fruits", "Breakfast"),
    Item("Grilled Chicken & Rice", "Lunch"),
    Item("Salmon & Sweet Potato", "Dinner"),
    Item("Protein Snack", "Snack")
)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(){
    Scaffold(
        modifier = Modifier.padding(10.dp).fillMaxSize().fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Center
        ) {
            ProfilePicture()

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
@Composable
fun FavoriteWorkouts(
    workouts : List<@Composable ()-> Unit>
){
    Column() {
        Swipeable(workouts)
    }
}

@Composable
fun FavoriteMeals(
    meals : List<@Composable () -> Unit>
){
    Column() {
        Swipeable(meals)
    }
}

@Composable
fun ProfilePicture(){
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.profile_pic),
            contentDescription = "User profile picture",
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(){
    FitnessTrackTheme() {
        ProfileScreen()
    }
}
