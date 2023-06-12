package com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.rememberAsyncImagePainter
import com.alife.anotherlife.core.composable.alife_card.model.UIAlifeCardModel
import com.alife.anotherlife.core.composable.image.ExtendImageBase
import java.io.File

class UILocalPicturesModel(
    private val firstUrl: String,
    private val secondUrl: String
) : UIAlifeCardModel {

//    @Composable
//    override fun getFirstPainter() = rememberAsyncImagePainter(File(firstUrl))
//
//    @Composable
//    override fun getSecondPainter() = rememberAsyncImagePainter(File(secondUrl))

    @Composable
    override fun FirstImage(modifier: Modifier) {
        ExtendImageBase(model = File(firstUrl), modifier = modifier)
    }

    @Composable
    override fun SecondImage(modifier: Modifier) {
        ExtendImageBase(model = File(secondUrl), modifier = modifier)
    }
}