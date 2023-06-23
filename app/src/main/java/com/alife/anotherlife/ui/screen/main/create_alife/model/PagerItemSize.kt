package com.alife.anotherlife.ui.screen.main.create_alife.model

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

interface PagerItemSize {

    fun size(): Int

    fun sizeDp(): Dp = size().dp


    class Default : PagerItemSize {
        override fun size(): Int = 60
    }

}