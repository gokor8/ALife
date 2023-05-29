package com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.model

import androidx.compose.runtime.Composable
import coil.compose.rememberAsyncImagePainter
import com.alife.anotherlife.core.composable.alife_card.model.UIAlifeCardModel
import java.io.File

class UILocalPicturesModel(
    private val firstUrl: String,
    private val secondUrl: String
) : UIAlifeCardModel {

    @Composable
    override fun getFirstPainter() = rememberAsyncImagePainter(File(firstUrl))

    @Composable
    override fun getSecondPainter() = rememberAsyncImagePainter(File(secondUrl))
}