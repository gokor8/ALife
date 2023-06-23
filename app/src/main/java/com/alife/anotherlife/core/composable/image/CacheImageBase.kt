package com.alife.anotherlife.core.composable.image

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.request.ImageRequest

interface ImageRequestBuilder {

    @Composable
    fun saveModel(): Any

}

@Composable
fun CacheImageBase(
    imageRequestBuilder: ImageRequestBuilder,
    contentScale: ContentScale = ContentScale.FillBounds,
    modifier: Modifier = Modifier
) {
    ExtendImageBase(imageRequestBuilder.saveModel(), contentScale, modifier)
}