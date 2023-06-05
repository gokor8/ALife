package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing

import android.net.Uri
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.BaseProfileReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.state.ProfileChangingEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.state.ProfileChangingState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ProfileUIDataModel
import javax.inject.Inject

class ProfileChangingReducer @Inject constructor(
    override val uiStore: UIStore<ProfileChangingState, ProfileChangingEffect>,
    private val profileReducer: BaseProfileReducer
) : HandlerBaseVMReducer<ProfileChangingState, ProfileChangingEffect>(),
    BaseProfileChangingReducer {

    override fun onProfileUIDataModel(profileUIDataModel: ProfileUIDataModel) {
        setState {
            copy(
                username = profileUIDataModel.username,
                photoUri = profileUIDataModel.photo,
                name = profileUIDataModel.name,
                description = profileUIDataModel.description
            )
        }
    }

    override fun onUsername(newUsername: String) {
        setState { copy(username = newUsername) }
    }

    override fun onPhoto(uri: Uri) {
        TODO("Not yet implemented")
    }

    override fun onName(newName: String) {
        setState { copy(name = newName) }
    }

    override fun onDescription(newescription: String) {
        setState { copy(description = newescription) }
    }

    override fun onSave() {
        // some save usecase
        profileReducer.onUsual()
    }

    override fun onDiscard() {
        profileReducer.onUsual()
    }
}