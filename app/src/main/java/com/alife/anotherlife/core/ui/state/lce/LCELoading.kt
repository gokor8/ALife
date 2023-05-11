package com.alife.anotherlife.core.ui.state.lce

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.composable.clickableNoRipple

object LCELoading : LCEModel.Loading {

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    override fun LCEContent(modifier: Modifier) {
        AnimatedContent(targetState = this) { LoadingScreen() }
    }
}

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier,
    onOpenScreen:() -> Unit = {},
    onBackgroundClick: () -> Unit = {},
    onProgressIndicatorClick: () -> Unit = {},
) = Box(
    contentAlignment = Alignment.Center,
    modifier = modifier
        .background(MaterialTheme.colorScheme.background)
        .clickableNoRipple(onClick = onBackgroundClick)
        .fillMaxSize()
) {
    CircularProgressIndicator(
        color = MaterialTheme.colorScheme.onBackground,
        modifier = Modifier.clickableNoRipple(onClick = onProgressIndicatorClick)
    )

    onOpenScreen()
}