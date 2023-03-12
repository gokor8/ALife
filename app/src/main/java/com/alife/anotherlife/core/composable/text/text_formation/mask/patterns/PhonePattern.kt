package com.alife.anotherlife.core.composable.text.text_formation.mask.patterns

import com.alife.anotherlife.core.composable.text.text_formation.mask.MaskList
import com.alife.anotherlife.core.composable.text.text_formation.mask.patterns.MaskPattern
import com.alife.anotherlife.core.composable.text.text_formation.mask.units.BaseUnits
import com.alife.anotherlife.core.composable.text.text_formation.mask.units.StaticUnits

class PhonePattern : MaskPattern {

    override fun getMaskPattern(): MaskList {
        return MaskList(
            StaticUnits.Plus(),
            BaseUnits.EmptyUnit(),
            StaticUnits.Space(),
            BaseUnits.EmptyUnit(),
            BaseUnits.EmptyUnit(),
            BaseUnits.EmptyUnit(),
            StaticUnits.Space(),
            BaseUnits.EmptyUnit(),
            BaseUnits.EmptyUnit(),
            BaseUnits.EmptyUnit(),
            StaticUnits.Separator(),
            BaseUnits.EmptyUnit(),
            BaseUnits.EmptyUnit(),
            StaticUnits.Separator(),
            BaseUnits.EmptyUnit(),
            BaseUnits.EmptyUnit(),
        )
    }
}