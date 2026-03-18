package com.example.fitnesstrack.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnesstrack.ui.screens.Item
import com.example.fitnesstrack.ui.theme.FitnessTrackTheme
import kotlin.collections.map

@Composable
fun RegularCard(
    item : Item
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier.size(width = 240.dp, height = 100.dp)
    ) {
        Row(modifier = Modifier.padding(10.dp)) {

            Column {
                Text(item.title, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                Text(item.subtitle, fontSize = 10.sp)
            }
        }
    }
}

data class Item(
    val title: String,
    val subtitle: String
)

val workouts = listOf(
    Item("Full Body Workout", "Beginner"),
    Item("HIIT Training", "Intermediate"),
    Item("Push Pull Legs", "Advanced"),
    Item("Core Workout", "All Levels")
)

val meals = listOf(
    Item("Oatmeal & Fruits", "Breakfast"),
    Item("Grilled Chicken & Rice", "Lunch"),
    Item("Salmon & Sweet Potato", "Dinner"),
    Item("Protein Snack", "Snack")
)
@Preview
@Composable
fun RegularCardPreview(){
    FitnessTrackTheme() {
        Swipeable(
            pages = meals.map { meal ->
                { RegularCard(meal) }
            }
        )
    }
}