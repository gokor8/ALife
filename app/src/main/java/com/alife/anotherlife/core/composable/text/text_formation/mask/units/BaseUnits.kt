package com.alife.anotherlife.core.composable.text.text_formation.mask.units

import com.alife.anotherlife.core.composable.text.text_formation.mask.MaskUnit

sealed interface BaseUnits : MaskUnit {

    fun getUnitBySymbol(newSymbol: Char?): BaseUnits


    class EmptyUnit : BaseUnits {

        override fun getUnitBySymbol(newSymbol: Char?): BaseUnits {
            return newSymbol?.run { SymbolUnit(newSymbol) } ?: this
        }
    }

    class SymbolUnit(symbol: Char) : MaskUnit.SymbolMaskUnit(symbol), BaseUnits {

        override fun getUnitBySymbol(newSymbol: Char?): BaseUnits {
            return newSymbol?.let { SymbolUnit(newSymbol) } ?: EmptyUnit()
        }
    }
}