package com.alife.anotherlife.core.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.semantics.Role

fun Modifier.clickableNoRipple(
    interactionSource: MutableInteractionSource = MutableInteractionSource(),
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: () -> Unit
): Modifier = composed {
    this.clickable(
        interactionSource = interactionSource,
        indication = null,
        enabled, onClickLabel, role, onClick
    )
}