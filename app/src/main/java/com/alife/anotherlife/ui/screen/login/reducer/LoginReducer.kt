package com.alife.anotherlife.ui.screen.login.reducer

interface LoginReducer {

    fun onInit()

    fun onLoginIn()

    suspend fun onRegistration()

    fun onAuthService()
}