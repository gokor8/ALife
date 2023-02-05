package com.alife.anotherlife.ui.example.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun UserScreen(userId: String?) = Box(modifier = Modifier, contentAlignment = Alignment.Center) {
    
    Text(text = userId ?: "null")
}