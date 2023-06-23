package com.alife.anotherlife.ui.screen.registration.tutorial.childrens

import android.widget.Space
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.addons.AlifeLogo
import com.alife.anotherlife.core.composable.brush.linearPurpleBrush
import com.alife.anotherlife.core.composable.icon.IconBase
import com.alife.anotherlife.core.composable.image.ImageBase
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Title18Style

class SecondTutorialScreen : BaseTutorialScreen(R.string.tutorial_second_description) {

    @Composable
    override fun MiddleContent(modifier: Modifier) {
        BoxWithConstraints(modifier.padding(horizontal = 16.dp)) {
            Row(
                modifier = Modifier
                    .zIndex(1f)
                    .padding(top = 88.dp)
                    .background(
                        MaterialTheme.colorScheme.onBackground.copy(alpha = 0.25f),
                        MaterialTheme.shapes.medium
                    )
                    .padding(horizontal = 38.dp, vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AlifeLogo(size = 34.dp)
                Spacer(modifier = Modifier.padding(start = 14.dp))

                TextBase(
                    textResId = R.string.tutorial_second_title,
                    style = Title18Style().style(),
                    textAlign = TextAlign.Center
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 50.dp)
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