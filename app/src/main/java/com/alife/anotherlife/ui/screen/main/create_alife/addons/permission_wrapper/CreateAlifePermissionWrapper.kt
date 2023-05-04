package com.alife.anotherlife.ui.screen.main.create_alife.addons.permission_wrapper

import androidx.compose.runtime.Composable
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.alife.core.mvi.MVIReducer

interface CreateAlifePermissionWrapper {

    @Composable
    fun SetupPermissions(action: MVIReducer.Base<CreateAlifeAction>, screenState: ScreenState)
}