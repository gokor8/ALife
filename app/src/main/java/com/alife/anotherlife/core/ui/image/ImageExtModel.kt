package com.alife.anotherlife.core.ui.image

import androidx.compose.foundation.layout.Box
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.alife.anotherlife.core.composable.image.ExtendImageBase

interface ImageExtModel {

    @Composable
    fun ImageContent(modifier: Modifier) = Unit


    abstract class Abstract<M : Any>(
        protected val model: M
    ) : ImageExtModel {

        @Composable
        override fun ImageContent(modifier: Modifier) {
            ExtendImageBase(
                model = model,
                contentScale = ContentScale.Crop,
                modifier = modifier
            )
        }

        override fun toString(): String = model.toString()
    }

    class Loading : ImageExtModel {

        @Composable
        override fun ImageContent(modifier: Modifier) {
            Box(modifier = modifier, contentAlignment = Alignment.Center) {
                CircularProgressIndicator(strokeWidth = 2.dp)
            }
        }
    }

    class Empty : ImageExtModel

    class Uri(uri: String) : Abstract<String>(uri)

    class File(file: java.io.File) : Abstract<java.io.File>(file) {

        @Composable
        override fun ImageContent(modifier: Modifier) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(model)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = modifier
            )
        }
    }
}