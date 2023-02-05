package com.alife.anotherlife.ui.example.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun UserScreen(userId: String?, userName: String?) = Column(
    modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally
) {

    Text(text = userId ?: "null")
    Text(text = userName ?: "null")
}