package com.alife.anotherlife.ui.screen.main.navigation_bar.home.model

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.composable.brush.verticalPrimaryGradient
import com.alife.anotherlife.core.composable.modifier.ModifierProvider

class HomeGradientModifier : ModifierProvider {

    @Composable
    override fun provideModifier(): Modifier {
        return Modifier.background(brush = verticalPrimaryGradient())
    }
}