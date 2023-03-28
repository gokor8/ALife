package com.alife.anotherlife.ui.screen.registration.tutorial.childrens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.brush.linearPurpleBrush
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Title18Style

class SecondTutorialScreen : BaseTutorialScreen(R.string.tutorial_second_description) {

    @Composable
    override fun MiddleContent(modifier: Modifier) {
        Box(
            modifier.padding(horizontal = 16.dp)
        ) {

            TextBase(
                textResId = R.string.tutorial_second_title,
                style = Title18Style().style(),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .zIndex(1f)
                    .padding(top = 88.dp)
                    .background(
                        MaterialTheme.colorScheme.onBackground.copy(alpha = 0.25f),
                        MaterialTheme.shapes.medium
                    )
                    .padding(horizontal = 30.dp, vertical = 16.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp)
                    .background(linearPurpleBrush(), MaterialTheme.shapes.medium)
            )
        }
    }
}

@Preview
@Composable
fun SecondTutorialScreenPreview() {
    SecondTutorialScreen().SetupContent()
}