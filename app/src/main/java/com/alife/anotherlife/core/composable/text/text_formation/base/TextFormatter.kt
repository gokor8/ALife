package com.alife.anotherlife.core.composable.text.text_formation.base

import com.alife.anotherlife.core.composable.text.text_formation.mask.MaskList

interface TextFormatter {

    fun format(inputModel: String, maskList: MaskList): String
}