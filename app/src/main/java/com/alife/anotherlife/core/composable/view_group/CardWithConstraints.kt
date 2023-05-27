package com.alife.anotherlife.core.composable.view_group

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape

@Composable
fun CardWithConstraints(
    modifier: Modifier = Modifier,
    innerModifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.large,
    colors: CardColors = CardDefaults.outlinedCardColors(),
    elevation: CardElevation = CardDefaults.outlinedCardElevation(),
    border: BorderStroke = CardDefaults.outlinedCardBorder(),
    content: @Composable BoxWithConstraintsScope.() -> Unit
) {
    OutlinedCard(modifier, shape, colors, elevation, border) {
        BoxWithConstraints(modifier = innerModifier, content = content)
    }
}