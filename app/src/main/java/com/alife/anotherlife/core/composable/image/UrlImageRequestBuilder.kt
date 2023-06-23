package com.alife.anotherlife.core.composable.image

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import coil.request.ImageRequest
import com.alife.anotherlife.core.composable.addons.BlurTransformation

abstract class UrlImageRequestBuilder(
    protected val url: String
) : ImageRequestBuilder {

    @Composable
    open fun imageRequest() = LocalContext.current.run {
        ImageRequest.Builder(this)
            .data(url)
            .diskCacheKey(url)
            .memoryCacheKey(url)
    }

    @Composable
    override fun saveModel(): Any = imageRequest().build()


    class Url(url: String) : UrlImageRequestBuilder(url)

    class BlurUrl(url: String) : UrlImageRequestBuilder(url) {

        @Composable
        override fun imageRequest() = super.imageRequest().transformations(BlurTransformation())
    }

    class SelectUrl(
        url: String,
        private val isBlur: Boolean = false
    ) : UrlImageRequestBuilder(url) {

        @Composable
        override fun imageRequest() = if (isBlur) {
            BlurUrl(url)
        } else {
            Url(url)
        }.imageRequest()
    }
}