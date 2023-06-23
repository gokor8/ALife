package com.alife.anotherlife.ui.activity

import com.alife.anotherlife.core.ui.view_model.ViewModelLCE
import com.alife.anotherlife.ui.activity.state.MainActivityAction
import com.alife.anotherlife.ui.activity.state.MainActivityEffect
import com.alife.anotherlife.ui.activity.state.MainActivityState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    override val reducerVM: BaseMainActivityReducer
) : ViewModelLCE<BaseMainActivityReducer, MainActivityAction, MainActivityState, MainActivityEffect>(
    reducerVM
)