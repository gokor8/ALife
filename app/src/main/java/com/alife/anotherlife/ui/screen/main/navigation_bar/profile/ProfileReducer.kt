package com.alife.anotherlife.ui.screen.main.navigation_bar.profile

import com.alife.anotherlife.core.ui.image.ImageExtModel
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.ProfileChangingFillState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.ProfileUsualFillState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.EmptyImageExtModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.InitUIProfileInfoModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.LceErrorProfileProvider
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.UIProfileInfoModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state.ProfileEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state.ProfileState
import com.alife.domain.main.profile.BaseUserProfileInfoUseCase
import com.alife.domain.main.profile.ExitProfileUseCase
import javax.inject.Inject

class ProfileReducer @Inject constructor(
    override val uiStore: UIStore<ProfileState, ProfileEffect>,
    private val profileInfoUseCase: BaseUserProfileInfoUseCase,
    private val exitProfileUseCase: ExitProfileUseCase
) : HandlerBaseVMReducer<ProfileState, ProfileEffect>(), BaseProfileReducer {

    override suspend fun onInit() {
        if (getState().profileUIDataModel is InitUIProfileInfoModel)
            setState { copy(lceModel = LCELoading) }

        executeThis(getState()) {
            copy(lceModel = LceErrorProfileProvider)
        }.handleThis(getState()) {
            val profileInfo = with(profileInfoUseCase.getProfileInfo()) {
                val photo = pictureUrl?.run { ImageExtModel.Uri(this) } ?: EmptyImageExtModel()

                UIProfileInfoModel(username, photo, name, description ?: "")
            }

            copy(
                lceModel = LCEContent,
                profileUIDataModel = profileInfo,
                contentFillState = ProfileUsualFillState(profileInfo)
            )
        }.apply(::setState)
    }

    override fun onChanging() {
        setState { copy(contentFillState = ProfileChangingFillState(profileUIDataModel)) }
    }

    override fun onChanging(profileInfo: UIProfileInfoModel) {
        setState { copy(contentFillState = ProfileChangingFillState(profileInfo)) }
    }

    override fun onUsual() {
        setState { copy(contentFillState = ProfileUsualFillState(profileUIDataModel)) }
    }

    override fun onUsual(profileInfo: UIProfileInfoModel) {
        setState {
            copy(
                contentFillState = ProfileUsualFillState(profileInfo),
                profileUIDataModel = profileInfo
            )
        }
    }

    override suspend fun onExit() {
        execute {
            setEffect(ProfileEffect.ProfileExitError())
        }.handle {
            exitProfileUseCase.exit()
            setEffect(ProfileEffect.Exit())
        }
    }

    override fun onBack() = Unit
}