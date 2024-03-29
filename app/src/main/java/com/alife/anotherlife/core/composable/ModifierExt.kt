package com.alife.anotherlife.core.composable

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.TabPosition
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun Modifier.clickableNoRipple(
    interactionSource: MutableInteractionSource = MutableInteractionSource(),
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: () -> Unit,
): Modifier = composed {
    this.clickable(
        interactionSource = remember { interactionSource },
        indication = null,
        enabled, onClickLabel, role, onClick
    )
}

fun Modifier.clickableNoRipple(
    coroutineScope: CoroutineScope,
    interactionSource: MutableInteractionSource = MutableInteractionSource(),
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: suspend () -> Unit,
): Modifier = composed {
    this.clickable(
        interactionSource = remember { interactionSource },
        indication = null,
        enabled, onClickLabel, role
    ) { coroutineScope.launch { onClick() } }
}

fun Modifier.clickable(
    coroutineScope: CoroutineScope,
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: suspend () -> Unit
): Modifier = this.clickable(
    enabled, onClickLabel, role
) { coroutineScope.launch { onClick() } }

fun Modifier.customTabIndicatorOffset(
    currentTabPosition: TabPosition,
    tabWidth: Dp
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "customTabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val currentTabWidth by animateDpAsState(
        targetValue = tabWidth,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
    )
    val indicatorOffset by animateDpAsState(
        targetValue = ((currentTabPosition.left + currentTabPosition.right - tabWidth) / 2),
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(currentTabWidth)
}