package com.alife.anotherlife.core.composable.mvi_extensions

import com.alife.anotherlife.core.ui.reducer.VMReducer

interface OnAction<R : VMReducer<*, *>> {

    fun onAction(reducer: R)
}