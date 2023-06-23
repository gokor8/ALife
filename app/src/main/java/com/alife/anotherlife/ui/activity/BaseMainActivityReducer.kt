package com.alife.anotherlife.ui.activity

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.activity.state.MainActivityEffect
import com.alife.anotherlife.ui.activity.state.MainActivityState

interface BaseMainActivityReducer : BaseVMReducer<MainActivityState, MainActivityEffect>