package com.alife.anotherlife.ui.screen.main.create_alife.state

import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.core.mvi.MVI

data class CreateAlifeState(
    val screenState: ScreenState = ScreenState.Load()
) : MVI.State {
}