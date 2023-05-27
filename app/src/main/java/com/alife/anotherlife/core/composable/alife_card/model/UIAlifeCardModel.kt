package com.alife.anotherlife.core.composable.alife_card.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

interface UIAlifeCardModel {

    @Composable
    fun getPainters(isReversed: Boolean): Pair<Painter, Painter> {
        return if(isReversed)
            Pair(getFirstPainter(), getSecondPainter())
        else
            Pair(getSecondPainter(), getFirstPainter())
    }

    @Composable
    fun getFirstPainter(): Painter

    @Composable
    fun getSecondPainter(): Painter


    class Default(
        @DrawableRes private val firstRes: Int,
        @DrawableRes private val secondRes: Int
    ) : UIAlifeCardModel {

        @Composable
        override fun getFirstPainter() = painterResource(firstRes)

        @Composable
        override fun getSecondPainter() = painterResource(secondRes)
    }
}