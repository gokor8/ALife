package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual

import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.BaseProfileReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.state.ProfileUsualEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.state.ProfileUsualState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ProfileUIDataModel
import javax.inject.Inject

class ProfileUsualReducer @Inject constructor(
    override val uiStore: UIStore<ProfileUsualState, ProfileUsualEffect>,
    private val profileReducer: BaseProfileReducer
) : HandlerBaseVMReducer<ProfileUsualState, ProfileUsualEffect>(),
    BaseProfileUsualReducer {

    override fun onProfileUIDataModel(profileUIDataModel: ProfileUIDataModel) {
        setState {
            copy(
                username = profileUIDataModel.username,
                photo = profileUIDataModel.photo,
                name = profileUIDataModel.name,
                description = profileUIDataModel.description
            )
        }
    }

    override fun onChanging() {
        profileReducer.onChanging()
    }

    override fun onBack() {

    }
}