package com.alife.anotherlife.core.composable.image

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.SubcomposeAsyncImage
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.addons.BaseProgressBar
import com.alife.anotherlife.core.composable.text.TextBase

@Composable
fun ExtendImageBase(
    model: Any,
    contentScale: ContentScale = ContentScale.FillBounds,
    modifier: Modifier = Modifier
) {
    SubcomposeAsyncImage(
        model = model,
        contentDescription = "",
        contentScale = contentScale,
        loading = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.background(MaterialTheme.colorScheme.background.copy(.8f))
            ) {
                BaseProgressBar()
            }
        },
        error = {
            Box(contentAlignment = Alignment.Center) {
                TextBase(textResId = R.string.image_error)
            }
        },
        modifier = modifier
    )
}