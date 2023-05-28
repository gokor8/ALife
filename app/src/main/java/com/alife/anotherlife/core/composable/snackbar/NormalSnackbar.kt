package com.alife.anotherlife.core.composable.snackbar

import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.alife.domain.core.delay.DelayWrapper

@Composable
fun OnlyTextSnackBar(text: String, modifier: Modifier) {
    Snackbar(modifier) { Text(text) }
}