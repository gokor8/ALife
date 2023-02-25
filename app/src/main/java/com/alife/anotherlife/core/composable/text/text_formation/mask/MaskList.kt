package com.alife.anotherlife.core.composable.text.text_formation.mask

import com.alife.anotherlife.core.composable.text.text_formation.mask.units.BaseUnits
import com.alife.anotherlife.core.composable.text.text_formation.mask.units.StaticUnits

class MaskList(listMasks: List<MaskUnit>) : ArrayList<MaskUnit>(listMasks) {

    constructor(vararg masks: MaskUnit) : this(masks.asList())

    fun getSymbolUnits(): List<Pair<Int, BaseUnits>> {
        val symbolUnitMap = mutableListOf<Pair<Int, BaseUnits>>()

        for (index in indices) {
            val currentUnit = get(index)

            if (currentUnit is BaseUnits) {
                symbolUnitMap.add(Pair(index, currentUnit))
            }
        }

        return symbolUnitMap
    }

    fun getClearSize() = count { maskUnit -> maskUnit is BaseUnits }

    fun maskUnitsCount(endRange: Int): Int {
        var count = 0
        for (unitIndex in 0 until endRange) {
            if (get(unitIndex) is StaticUnits) count++
        }
        return count
    }

    private fun getFirstStaticUnits(): Int {
        var count = 0

        for (index in 0 until size) {
            if (get(index) !is BaseUnits)
                count++
            else
                break
        }
        return count
    }

    fun notEmptyUnitCount(endRange: Int): Int {
        var count = 0
        for (unitIndex in 0 .. getFirstStaticUnits() + endRange) {
            if(get(unitIndex) is StaticUnits && unitIndex == endRange) break
            if (get(unitIndex) !is BaseUnits.EmptyUnit)
                count++
            else
                break
        }
        return count
    }

    fun isStaticAndNextEmpty(index: Int): Boolean {
        return get(index) is StaticUnits && getOrNull(index + 1) is BaseUnits.EmptyUnit
    }

    //12.12.2222
    //1
    fun getOffsetPosition(endRange: Int): Int {
        //var offsetCount = getFirstStaticUnits() + endRange
        var count = 0
        for (unitIndex in 0 until getFirstStaticUnits() + endRange) {
            if(get(unitIndex) is StaticUnits) count++
            if(get(unitIndex) is StaticUnits && unitIndex == endRange) break
            if (get(unitIndex) !is BaseUnits.EmptyUnit)
                count++
            else
                break
        }
        return count
    }
}