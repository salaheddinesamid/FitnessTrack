package com.example.fitnesstrack.services

import android.content.Context

class AuthManager(context : Context) {

    private val prefs = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE);

    fun saveAccessToken(token : String){
        prefs.edit().putString("access_token", token)
    }

    fun getAccessToken() : String? {
        return prefs.getString("access_token", null)
    }

    fun isLoggedIn() : Boolean{
        return getAccessToken() != null;
    }

    fun logOut() {
        prefs.edit().remove("access_token")
    }
}