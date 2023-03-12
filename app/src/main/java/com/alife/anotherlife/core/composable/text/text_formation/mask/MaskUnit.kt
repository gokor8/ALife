package com.alife.anotherlife.core.composable.text.text_formation.mask

interface MaskUnit {
    abstract class SymbolMaskUnit(val symbol: Char) : MaskUnit
}