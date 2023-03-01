package com.alife.anotherlife.core.composable.text.text_formation.mask.units

import com.alife.anotherlife.core.composable.text.text_formation.mask.MaskUnit


abstract class StaticUnits(symbol: Char) : MaskUnit.SymbolMaskUnit(symbol) {

    class Space : StaticUnits(' ')

    class RusCode : StaticUnits('7')

    class Dot : StaticUnits('.')

    class Email : StaticUnits('@')

    class Separator : StaticUnits('-')

    class Plus : StaticUnits('+')
}