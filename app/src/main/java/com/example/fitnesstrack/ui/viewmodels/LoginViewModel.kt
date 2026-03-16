package com.example.fitnesstrack.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class LoginViewModel {

    var email by mutableStateOf("")
    var password by mutableStateOf("")

    var loginSuccessful by mutableStateOf(false)
        private set
    var errorMessage by mutableStateOf("")
        private set

    fun login(){}
}