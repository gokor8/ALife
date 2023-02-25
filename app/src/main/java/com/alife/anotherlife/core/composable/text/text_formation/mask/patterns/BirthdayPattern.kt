package com.alife.anotherlife.core.composable.text.text_formation.mask.patterns

import com.alife.anotherlife.core.composable.text.text_formation.mask.MaskList
import com.alife.anotherlife.core.composable.text.text_formation.mask.units.BaseUnits
import com.alife.anotherlife.core.composable.text.text_formation.mask.units.StaticUnits

class BirthdayPattern {
    val birthdayMask = MaskList(
        BaseUnits.EmptyUnit(),
        BaseUnits.EmptyUnit(),
        StaticUnits.Dot(),
        BaseUnits.EmptyUnit(),
        BaseUnits.EmptyUnit(),
        StaticUnits.Dot(),
        BaseUnits.EmptyUnit(),
        BaseUnits.EmptyUnit(),
        BaseUnits.EmptyUnit(),
        BaseUnits.EmptyUnit()
    )

    val birthdayTestMask = MaskList(
        BaseUnits.SymbolUnit('t'),
        BaseUnits.SymbolUnit('t'),
        StaticUnits.Dot(),
        BaseUnits.SymbolUnit('t'),
        BaseUnits.SymbolUnit('t'),
        StaticUnits.Dot(),
        BaseUnits.SymbolUnit('t'),
        BaseUnits.SymbolUnit('t'),
        BaseUnits.SymbolUnit('t'),
        BaseUnits.SymbolUnit('t'),
    )
}