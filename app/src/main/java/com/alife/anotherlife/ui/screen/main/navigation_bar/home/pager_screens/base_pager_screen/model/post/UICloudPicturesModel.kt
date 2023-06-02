package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post

import androidx.compose.runtime.Composable
import coil.compose.rememberAsyncImagePainter
import com.alife.anotherlife.core.composable.alife_card.model.UIAlifeCardModel
import java.io.File

class UICloudPicturesModel (
    private val firstUrl: String,
    private val secondUrl: String
) : UIAlifeCardModel {

    @Composable
    override fun getFirstPainter() = rememberAsyncImagePainter(firstUrl)

    @Composable
    override fun getSecondPainter() = rememberAsyncImagePainter(secondUrl)
}