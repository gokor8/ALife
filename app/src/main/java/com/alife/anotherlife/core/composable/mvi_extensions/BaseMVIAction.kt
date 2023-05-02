package com.alife.anotherlife.core.composable.mvi_extensions

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.core.mvi.MVI

interface BaseMVIAction<R : BaseVMReducer<*, *>> : MVI.Action, OnAction<R>