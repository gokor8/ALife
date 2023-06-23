package com.alife.anotherlife.core.composable.text.text_formation.base

import com.alife.anotherlife.core.composable.text.text_formation.mask.MaskList
import com.alife.anotherlife.core.composable.text.text_formation.mask.MaskUnit
import com.alife.anotherlife.core.composable.text.text_formation.mask.units.BaseUnits
import com.alife.anotherlife.core.composable.text.text_formation.mask.units.StaticUnits

class MaskTextFormatter : TextFormatter {

    override fun format(inputModel: String, maskList: MaskList): String {
        // First cycle, for fill symbol and empty mask units
        val symbolUnitMap = maskList.getBaseUnits()
        for (index in symbolUnitMap.indices) {
            val unitIndex = symbolUnitMap[index].first
            val unit = symbolUnitMap[index].second

            maskList[unitIndex] = unit.getUnitBySymbol(inputModel.getOrNull(index))
        }

        var formattedText = ""
        // second cycle for Fill formatted Text
        for (index in maskList.indices) {
            val currentUnit = maskList[index]

            if (currentUnit is StaticUnits
                && maskList.getOrNull(index + 1) is BaseUnits.EmptyUnit
            ) break
            // is EmptyMask
            if (currentUnit !is MaskUnit.SymbolMaskUnit) break

            formattedText += currentUnit.symbol
        }

        return formattedText
    }
}