package com.alife.anotherlife.ui.screen.main.create_alife

import com.alife.anotherlife.core.composable.mvi_extensions.DefaultViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class CreateAlifeViewModel(
    reducer: BaseCreateAlifeReducer
) : DefaultViewModel<BaseCreateAlifeReducer, CreateAlifeAction, CreateAlifeState, CreateAlifeEffect>(
    reducer
)