package com.alife.anotherlife.ui.screen.splash

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.image.ImageBase
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.ui.screen.splash.state.SplashAction
import kotlinx.coroutines.delay

class SplashScreen(override val navController: NavController) : VMScreen<SplashViewModel>() {

    @Composable
    override fun setupViewModel(): SplashViewModel = hiltViewModel()

    override suspend fun onInit() {
        viewModel.reduce(SplashAction.Init())
    }

    @Composable
    override fun Content(modifier: Modifier) {
        val infiniteTransition = rememberInfiniteTransition()

        val startPulseValue = 1f
        val pulseFraction = 1.2f

        val scale by infiniteTransition.animateFloat(
            initialValue = startPulseValue,
            targetValue = pulseFraction,
            animationSpec = infiniteRepeatable(
                animation = tween(1000),
                repeatMode = RepeatMode.Reverse
            ), label = ""
        )

        Box(
            modifier = modifier.scale(scale),
            contentAlignment = Alignment.Center
        ) {
            ImageBase(
                resId = R.drawable.ic_alife_logo,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                modifier = Modifier.size(100.dp)
            )
        }
    }
}