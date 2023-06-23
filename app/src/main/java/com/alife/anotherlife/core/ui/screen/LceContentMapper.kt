package com.alife.anotherlife.core.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.ui.state.lce.LCEModel

interface LceContentMapper {

    @Composable
    fun Map(lceModel: LCEModel, modifier: Modifier) = lceModel.LCEContent(modifier)


    class Default : LceContentMapper
}