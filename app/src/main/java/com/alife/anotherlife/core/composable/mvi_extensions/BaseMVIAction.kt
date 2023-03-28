package com.alife.anotherlife.core.composable.mvi_extensions

import com.alife.anotherlife.core.ui.reducer.VMReducer
import com.alife.core.mvi.MVI

interface BaseMVIAction<R : VMReducer<*, *>> : MVI.Action, OnAction<R>