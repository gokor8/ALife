package com.alife.anotherlife.core.composable.mvi_extensions

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer

interface OnAction<R : BaseVMReducer<*, *>> {

    suspend fun onAction(reducer: R)
}