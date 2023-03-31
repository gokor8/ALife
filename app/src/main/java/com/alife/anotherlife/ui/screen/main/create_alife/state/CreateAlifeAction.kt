package com.alife.anotherlife.ui.screen.main.create_alife.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.create_alife.BaseCreateAlifeReducer

interface CreateAlifeAction : BaseMVIAction<BaseCreateAlifeReducer> {

    class PermissionGrantedAction : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducer) {
            reducer.onPermissionGranted()
        }
    }
}