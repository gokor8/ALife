package com.alife.anotherlife.core.composable.alife_card.mapper

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

class DpToPx : BaseDpToPx {

    @Composable
    override fun map(value: Dp) = with(LocalDensity.current) { value.toPx() }
}