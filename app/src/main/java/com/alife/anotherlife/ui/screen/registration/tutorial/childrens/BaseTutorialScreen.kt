package com.alife.anotherlife.ui.screen.registration.tutorial.childrens

import androidx.annotation.StringRes
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Button18
import com.alife.anotherlife.core.composable.text.style.Title22Style
import com.alife.anotherlife.core.composable.text.style.Title28Style
import com.alife.anotherlife.core.ui.screen.DefaultScreen

abstract class BaseTutorialScreen(
    @StringRes private val textRes: Int,
) : DefaultScreen() {

    @Composable
    protected abstract fun MiddleContent(modifier: Modifier)

    @Composable
    protected open fun BottomContent() = Unit

    @Composable
    override fun Content(modifier: Modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            TextBase(textResId = R.string.horizontal_short_logo, style = Title28Style().style())

            MiddleContent(
                Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(vertical = 28.dp)
            )

            TextBase(
                textResId = textRes,
                style = Title22Style().style(),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 35.dp)
            )
            Spacer(modifier = Modifier.padding(bottom = 50.dp))
            Spacer(modifier = Modifier.weight(1f))

            BottomContent()
        }
    }
}