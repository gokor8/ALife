package com.alife.anotherlife.core.composable.alife_card.model

import androidx.annotation.DrawableRes
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.composable.image.ExtendImageBase

interface UIAlifeCardModel {

    @Composable
    fun Images(
        isReversed: Boolean,
        smallImageModifier: Modifier,
        mainImageModifier: Modifier
    ) {
        Box {
            Crossfade(
                isReversed,
                animationSpec = spring(2f),
                label = ""
            ) { isReversed ->
                if (isReversed) {
                    SecondImage(mainImageModifier)
                    FirstImage(smallImageModifier)
                } else {
                    FirstImage(mainImageModifier)
                    SecondImage(smallImageModifier)
                }
            }
        }
    }

    @Composable
    fun FirstImage(modifier: Modifier)

    @Composable
    fun SecondImage(modifier: Modifier)


    class Default(
        @DrawableRes private val firstRes: Int,
        @DrawableRes private val secondRes: Int
    ) : UIAlifeCardModel {

        @Composable
        override fun FirstImage(modifier: Modifier) {
            ExtendImageBase(model = firstRes, modifier = modifier)
        }

        @Composable
        override fun SecondImage(modifier: Modifier) {
            ExtendImageBase(model = secondRes, modifier = modifier)
        }
    }
}