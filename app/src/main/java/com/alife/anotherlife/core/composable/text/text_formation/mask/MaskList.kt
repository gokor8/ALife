package com.alife.anotherlife.core.composable.text.text_formation.mask

import com.alife.anotherlife.core.composable.text.text_formation.mask.units.BaseUnits
import com.alife.anotherlife.core.composable.text.text_formation.mask.units.StaticUnits

class MaskList(listMasks: List<MaskUnit>) : ArrayList<MaskUnit>(listMasks) {

    constructor(vararg masks: MaskUnit) : this(masks.asList())

    fun getBaseUnits(): List<Pair<Int, BaseUnits>> {
        val symbolUnitMap = mutableListOf<Pair<Int, BaseUnits>>()

        for (index in indices) {
            val currentUnit = get(index)

            if (currentUnit is BaseUnits) {
                symbolUnitMap.add(Pair(index, currentUnit))
            }
        }

        return symbolUnitMap
    }

    fun getClearCount() = count { maskUnit -> maskUnit is BaseUnits }

    //12.12.2222
    // offset дает позицию каретки без StaticMaskUnit ов
    //12.(3)12
    //121(3)
    fun toTransformOffsetPosition(originOffset: Int): Int {
        var symbolUnitCount = 0
        var staticUnitCount = 0
        var index = 0
        while (symbolUnitCount != originOffset) {
            if (getOrNull(index) is BaseUnits.EmptyUnit) break

            getOrNull(index)?.also { maskUnit ->
                if (maskUnit is StaticUnits) {
                    staticUnitCount++
                } else {
                    symbolUnitCount++
                }
            } ?: break

            index++
        }

        return symbolUnitCount + staticUnitCount
    }

    fun toOriginOffsetPosition(transformOffset: Int): Int {
        var staticUnitsCount = 0
        for (unitIndex in 0 until transformOffset) {
            if (get(unitIndex) is StaticUnits) staticUnitsCount++
        }
        return transformOffset - staticUnitsCount
    }

    override fun toString(): String {
        return joinToString(separator = "") {
            (it as? MaskUnit.SymbolMaskUnit)?.symbol?.toString() ?: ""
        }
    }
}