package com.alife.anotherlife.core.composable.map.listeners

interface AddRemoveMapListener<M> {

    fun addListener(model: M)

    fun removeListener(model: M)
}