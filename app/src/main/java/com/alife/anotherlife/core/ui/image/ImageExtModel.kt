package com.alife.anotherlife.core.ui.image

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter

interface ImageExtModel {

    @Composable
    fun ImageContent(modifier: Modifier) = Unit


    abstract class Abstract<M : Any>(
        protected val model: M
    ) : ImageExtModel {

        @Composable
        override fun ImageContent(modifier: Modifier) {
            Image(
                painter = rememberAsyncImagePainter(model),
                contentScale = ContentScale.Crop,
                contentDescription = "",
            )
        }
    }

    class Empty : ImageExtModel

    open class Uri(uri: String) : Abstract<String>(uri)

    open class File(file: java.io.File) : Abstract<java.io.File>(file)
}