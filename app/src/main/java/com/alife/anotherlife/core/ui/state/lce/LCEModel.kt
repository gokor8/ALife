package com.alife.anotherlife.core.ui.state.lce

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface LCEModel {

    @Composable
    fun LCEContent(modifier: Modifier)


    interface Loading : LCEModel

    interface Content : LCEModel

    interface Error : LCEModel
}