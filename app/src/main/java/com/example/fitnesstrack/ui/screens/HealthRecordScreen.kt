package com.example.fitnesstrack.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fitnesstrack.ui.theme.FitnessBlue
import com.example.fitnesstrack.ui.theme.FitnessGreen
import com.example.fitnesstrack.ui.theme.FitnessTrackTheme
import com.example.fitnesstrack.ui.viewmodels.HealthRecordViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HealthRecordScreen(){
    Scaffold(
        modifier = Modifier.padding(10.dp),
        topBar = { TopAppBar(title = { Text("Health Record") }) }
    ) {
        HealthRecordForm(vm = HealthRecordViewModel())
    }
}

@Composable
fun HealthRecordDetails(vm: HealthRecordViewModel){
    Column(){
        Text("Current Height: ${vm.height}")
        Text("Last weight: ${vm.weight}")
    }
}

@Composable
fun HealthRecordForm(vm: HealthRecordViewModel){
    Column(
        modifier = Modifier.padding(top = 100.dp, start = 20.dp, end = 20.dp).height(500.dp),
    ) {
        HealthRecordDetails(vm = HealthRecordViewModel())
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = vm.height.toString(),
            onValueChange = { vm.height = it.toDouble() },
            label = { Text("Enter your height (cm)")},

            )
        OutlinedTextField(
            value = vm.weight.toString(),
            onValueChange = { vm.weight = it.toDouble() },
            label = {Text("Enter your current weight (KG)")}

        )
        Spacer(modifier = Modifier.height(10.dp))
        Column () {
            Text("Current BMI: ${vm.currentBMI}")
            Spacer(modifier = Modifier.height(10.dp))
            Text("Perfect BMI: ${vm.perfectBMI}")
        }
        Spacer(modifier = Modifier.height(10.dp))
        BodyFatStatus()

        Spacer(modifier = Modifier.height(10.dp))
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Button (onClick = { vm.calculateBMI() }, colors = ButtonDefaults.buttonColors(
                containerColor = FitnessGreen,
                contentColor = Color.White
            )) {
                Text("Save")
            }

        }
    }
}

@Composable
fun BodyFatStatus(){
    LinearProgressIndicator(
        progress = 0.8f,
        color = FitnessBlue,
        modifier = Modifier.padding(10.dp)
    )
}


@Composable
fun HealthRecordFormPreview(){
    val vm = HealthRecordViewModel()
    FitnessTrackTheme (){
        HealthRecordForm(vm)
    }
}
@Preview(showBackground = true)
@Composable
fun HealthRecordScreenPreview(){
    FitnessTrackTheme () {
        HealthRecordScreen()
    }
}