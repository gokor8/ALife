package com.alife.anotherlife.core.composable.icon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R

@Composable
fun MockProfileIcon(modifier: Modifier = Modifier) {
    val color = MaterialTheme.colorScheme.secondary

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(color = color, CircleShape)
            .padding(vertical = 4.dp, horizontal = 6.dp)
    ) {
        IconBase(icon = R.drawable.ic_profile_mock, Modifier.size(32.dp))
    }
}