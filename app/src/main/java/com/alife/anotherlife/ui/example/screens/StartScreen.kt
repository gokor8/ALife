package com.alife.anotherlife.ui.example.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.ui.example.navigation.user.navigator.UserArgsNavigator

@Composable
fun StartScreen(navController: NavController) =
    Box(modifier = Modifier, contentAlignment = Alignment.Center) {

        Button(
            onClick = {
                NavigationWrapper.Navigate(UserArgsNavigator("aboba")).navigate(navController)
            }
        ) {}
    }