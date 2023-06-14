package com.alife.anotherlife.ui.screen.main.navigation_bar.map.model

class SizeInvertiblePair<M>(
    private val first: M,
    private val second: M
) {

    fun getPair(isInverted: Boolean) = if(isInverted) {
        Pair(first, second)
    } else {
        Pair(second, first)
    }
}