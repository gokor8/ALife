package com.alife.anotherlife.ui.screen.registration.tutorial

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.image.ImageBase
import com.alife.anotherlife.core.composable.text.style.Button18

class ThirdTutorialScreen : BaseTutorialScreen(R.string.tutorial_third_description) {

    @Composable
    override fun MiddleContent(modifier: Modifier) {
        ImageBase(
            resId = R.drawable.img_tutorial_third,
            contentScale = ContentScale.FillBounds,
            modifier = modifier.padding(horizontal = 38.dp)
        )
    }

    @Composable
    override fun BottomContent() {
        val height = animateDpAsState(
            targetValue = 60.dp,
            animationSpec = tween(
                durationMillis = 1300,
                easing = LinearEasing
            )
        )

        Button18(
            textResId = R.string.continue_next,
            modifier = Modifier.height(height.value)
        ) {

        }
    }
}

@Preview
@Composable
fun ThirdTutorialScreenPreview() {
    ThirdTutorialScreen().SetupContent()
}