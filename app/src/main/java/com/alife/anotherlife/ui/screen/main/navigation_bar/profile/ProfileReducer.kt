package com.alife.anotherlife.ui.screen.main.navigation_bar.profile

import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.ProfileChangingFillState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.ProfileUsualFillState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ContentFillState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.EmptyProfileUIDataModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ProfileUIDataModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state.ProfileEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state.ProfileState
import javax.inject.Inject

class ProfileReducer @Inject constructor(
    override val uiStore: UIStore<ProfileState, ProfileEffect>
) : HandlerBaseVMReducer<ProfileState, ProfileEffect>(), BaseProfileReducer {

    override suspend fun onInit() {
        if (getState().profileUIDataModel is EmptyProfileUIDataModel)
            setState { copy(lceModel = LCELoading) }

        // TODO load data
        val result = ProfileUIDataModel(
            "TestName",
            "TestUresname",
            "",
            "TestDescriptionaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n aaaa\n aaaa"
        )

        setState {
            copy(
                lceModel = LCEContent,
                profileUIDataModel = result,
                contentFillState = ProfileUsualFillState(result)
            )
        }
    }

    override fun onChanging() {
        setState { copy(contentFillState = ProfileChangingFillState(profileUIDataModel)) }
    }

    override fun onUsual() {
        setState { copy(contentFillState = ProfileUsualFillState(profileUIDataModel)) }
    }

    override fun onBack() {

    }
}