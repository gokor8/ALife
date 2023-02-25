package com.alife.anotherlife.core.composable.text.text_formation.mask

interface MaskUnit {

    fun getOffset() = 1
    fun format(symbol: String): String = symbol


    abstract class UnitMask(val symbol: Char) : MaskUnit
}