package com.alife.anotherlife.core.composable.padding

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.Dp

class BottomPaddingModel(private val paddingValues: PaddingValues) {

    fun safeCalculateBottomPadding(depriveDp: Dp): Dp {
        val bottomPadding = paddingValues.calculateBottomPadding()

        return if(bottomPadding > depriveDp) bottomPadding - depriveDp else bottomPadding
    }
}