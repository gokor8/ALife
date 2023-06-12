package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.composable.alife_card.model.UIAlifeCardModel
import com.alife.anotherlife.core.composable.image.CacheImageBase
import com.alife.anotherlife.core.composable.image.UrlImageRequestBuilder

class UICloudPicturesModel(
    private val firstUrl: String,
    private val secondUrl: String
) : UIAlifeCardModel {

    @Composable
    override fun FirstImage(modifier: Modifier) {
        CacheImageBase(
            imageRequestBuilder = UrlImageRequestBuilder.Url(firstUrl),
            modifier = modifier
        )
    }

    @Composable
    override fun SecondImage(modifier: Modifier) {
        CacheImageBase(
            imageRequestBuilder = UrlImageRequestBuilder.Url(secondUrl),
            modifier = modifier
        )
    }
}