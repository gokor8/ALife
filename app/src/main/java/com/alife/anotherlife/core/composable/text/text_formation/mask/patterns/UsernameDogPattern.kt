package com.alife.anotherlife.core.composable.text.text_formation.mask.patterns

import com.alife.anotherlife.core.composable.text.text_formation.mask.MaskList
import com.alife.anotherlife.core.composable.text.text_formation.mask.units.BaseUnits
import com.alife.anotherlife.core.composable.text.text_formation.mask.units.StaticUnits

class UsernameDogPattern : MaskPattern {

    override fun getMaskPattern(): MaskList {
        val symbolUnitsCount = (0..10).map { BaseUnits.EmptyUnit() }

        return MaskList(StaticUnits.Email()).apply { addAll(MaskList(symbolUnitsCount)) }
    }
}