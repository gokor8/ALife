package com.alife.anotherlife.core.ui.reducer

import com.alife.core.mvi.MVI
import com.alife.core.mvi.addons.BaseMVIHandlers
import com.alife.core.mvi.addons.SuspendMVIHandlers

interface BaseVMReducer<STATE : MVI.State, EFFECT : MVI.Effect> :
    BaseReducerCollector<STATE, EFFECT>, BaseMVIHandlers<STATE, EFFECT>,
    SuspendMVIHandlers<STATE, EFFECT>