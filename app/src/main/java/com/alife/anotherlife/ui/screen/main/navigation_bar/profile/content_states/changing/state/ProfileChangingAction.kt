package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.state

import android.net.Uri
import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.BaseProfileChangingReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ProfileUIDataModel

interface ProfileChangingAction : BaseMVIAction<BaseProfileChangingReducer> {

    class OnInit(private val profileUIDataModel: ProfileUIDataModel) : ProfileChangingAction {
        override suspend fun onAction(reducer: BaseProfileChangingReducer) {
            reducer.onProfileUIDataModel(profileUIDataModel)
        }
    }

    class OnUsername(private val newUsername: String): ProfileChangingAction {
        override suspend fun onAction(reducer: BaseProfileChangingReducer) {
            reducer.onUsername(newUsername)
        }
    }

    class OnPhoto(private val uri: Uri) : ProfileChangingAction {
        override suspend fun onAction(reducer: BaseProfileChangingReducer) {
            reducer.onPhoto(uri)
        }
    }

    class OnName(private val newName: String): ProfileChangingAction {
        override suspend fun onAction(reducer: BaseProfileChangingReducer) {
            reducer.onName(newName)
        }
    }

    class OnDescription(private val newDescription: String): ProfileChangingAction {
        override suspend fun onAction(reducer: BaseProfileChangingReducer) {
            reducer.onDescription(newDescription)
        }
    }
}