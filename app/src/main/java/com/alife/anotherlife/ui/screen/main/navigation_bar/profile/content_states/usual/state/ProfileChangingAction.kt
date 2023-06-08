package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.BaseProfileUsualReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.UIProfileInfoModel

interface ProfileUsualAction : BaseMVIAction<BaseProfileUsualReducer> {

    class OnInit(private val profileInfo: UIProfileInfoModel) : ProfileUsualAction {
        override suspend fun onAction(reducer: BaseProfileUsualReducer) {
            reducer.onProfileUIDataModel(profileInfo)
        }
    }

    class StartChanging : ProfileUsualAction {
        override suspend fun onAction(reducer: BaseProfileUsualReducer) {
            reducer.onChanging()
        }
    }

    class Back : ProfileUsualAction {
        override suspend fun onAction(reducer: BaseProfileUsualReducer) {
            reducer.onBack()
        }
    }
}