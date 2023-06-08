package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing

import android.net.Uri
import android.util.Log
import com.alife.anotherlife.core.ui.image.ImageExtModel
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.BaseProfileReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.state.ProfileChangingState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.UIProfileInfoModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state.ProfileEffect
import com.alife.data.repository.main.profile.model.PhotoUriWrapper
import com.alife.domain.main.profile.BaseSaveProfileDataUseCase
import com.alife.domain.main.profile.entity.ProfileMainInfoEntity
import java.io.IOException
import javax.inject.Inject

class ProfileChangingReducer @Inject constructor(
    override val uiStore: UIStore<ProfileChangingState, ProfileEffect>,
    private val profileReducer: BaseProfileReducer,
    private val saveProfileDataUseCase: BaseSaveProfileDataUseCase
) : HandlerBaseVMReducer<ProfileChangingState, ProfileEffect>(),
    BaseProfileChangingReducer {

    override fun onProfileUIDataModel(profileUIDataModel: UIProfileInfoModel) {
        setState { copy(profileInfo = profileUIDataModel) }
    }

    override fun onUsername(newUsername: String) {
        setState { copy(profileInfo = copyUsername(newUsername)) }
    }

    override suspend fun onPhoto(uri: Uri) {
        val previousPhoto = getState().profileInfo.photo

        setState { copy(profileInfo = copyPhoto(ImageExtModel.Loading())) }

        execute {
            setState { copy(profileInfo = copyPhoto(previousPhoto)) }
            profileReducer.trySetEffect(ProfileEffect.ProfilePhotoUploadError())
        }.handle {
            val file = saveProfileDataUseCase.saveProfileImage(PhotoUriWrapper(uri))

            setState { copy(profileInfo = copyPhoto(ImageExtModel.File(file))) }
        }
    }

    override fun onName(newName: String) {
        setState { copy(profileInfo = copyName(newName)) }
    }

    override fun onDescription(newDescription: String) {
        setState { copy(profileInfo = copyDescription(newDescription)) }
    }

    override suspend fun onSave() {
        execute {
            Log.d("Aboba exc", it.toString())
            profileReducer.trySetEffect(ProfileEffect.ProfileInfoUploadError())
        }.handleThis(getState().profileInfo) {
            saveProfileDataUseCase.saveData(ProfileMainInfoEntity(username, name, description))
            profileReducer.onUsual(this)
        }
    }

    override fun onDiscard() {
        profileReducer.onUsual()
    }
}