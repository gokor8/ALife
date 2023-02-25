package com.alife.anotherlife.core.composable.text.text_formation.mask.units

import com.alife.anotherlife.core.composable.text.text_formation.mask.MaskUnit


sealed class StaticUnits(symbol: Char) : MaskUnit.UnitMask(symbol) {

    class Space : StaticUnits(' ')

    class RusCode : StaticUnits('7')

    class Dot : StaticUnits('.')

    class Separator : StaticUnits('-') {
        override fun format(newSymbol: String): String {
            return "$newSymbol$symbol"
        }
    }
    class Plus : StaticUnits('+')
}