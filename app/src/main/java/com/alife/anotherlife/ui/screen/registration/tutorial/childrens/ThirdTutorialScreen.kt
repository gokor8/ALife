package com.alife.anotherlife.ui.screen.registration.tutorial.childrens

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.image.ImageBase

class ThirdTutorialScreen : BaseTutorialScreen(R.string.tutorial_third_description) {

    @Composable
    override fun MiddleContent(modifier: Modifier) {
        ImageBase(
            resId = R.drawable.img_tutorial_third,
            contentScale = ContentScale.FillBounds,
            modifier = modifier.padding(horizontal = 38.dp)
        )
    }
}

@Preview
@Composable
fun ThirdTutorialScreenPreview() {
    ThirdTutorialScreen().SetupContent()
}