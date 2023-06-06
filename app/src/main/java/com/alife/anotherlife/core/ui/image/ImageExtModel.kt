package com.alife.anotherlife.core.ui.image

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import coil.compose.rememberAsyncImagePainter

interface ImageExtModel {

    @Composable
    fun ImageContent() = Unit


    abstract class Abstract<M : Any>(
        protected val model: M
    ) : ImageExtModel {

        @Composable
        override fun ImageContent() {
            Image(
                painter = rememberAsyncImagePainter(model),
                contentDescription = "",
            )
        }
    }

    class Empty : ImageExtModel

    open class Uri(uri: String) : Abstract<String>(uri)

    open class File(file: java.io.File) : Abstract<java.io.File>(file)
}