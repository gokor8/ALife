package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing

import android.net.Uri
import android.util.Log
import com.alife.anotherlife.core.ui.image.ImageExtModel
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.BaseProfileReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.state.ProfileChangingEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.state.ProfileChangingState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ProfileUIDataModel
import com.alife.data.repository.main.profile.model.PhotoUriWrapper
import com.alife.domain.main.profile.BaseReadNewProfilePhotoUseCase
import com.alife.domain.main.profile.BaseSaveProfileDataUseCase
import com.alife.domain.main.profile.entity.ProfileMainInfoEntity
import javax.inject.Inject

class ProfileChangingReducer @Inject constructor(
    override val uiStore: UIStore<ProfileChangingState, ProfileChangingEffect>,
    private val profileReducer: BaseProfileReducer,
    private val readNewProfilePhoto: BaseReadNewProfilePhotoUseCase,
    private val saveProfileDataUseCase: BaseSaveProfileDataUseCase
) : HandlerBaseVMReducer<ProfileChangingState, ProfileChangingEffect>(),
    BaseProfileChangingReducer {

    override fun onProfileUIDataModel(profileUIDataModel: ProfileUIDataModel) {
        setState {
            copy(
                username = profileUIDataModel.username,
                photo = profileUIDataModel.photo,
                name = profileUIDataModel.name,
                description = profileUIDataModel.description ?: ""
            )
        }
    }

    override fun onUsername(newUsername: String) {
        setState { copy(username = newUsername) }
    }

    override suspend fun onPhoto(uri: Uri) {
        execute {

        }.handle {
            val file = readNewProfilePhoto.getPhoto(PhotoUriWrapper(uri))
            saveProfileDataUseCase.saveProfileImage(PhotoUriWrapper(uri))

            setState { copy(photo = ImageExtModel.File(file)) }
        }
    }

    override fun onName(newName: String) {
        setState { copy(name = newName) }
    }

    override fun onDescription(newDescription: String) {
        setState { copy(description = newDescription) }
    }

    override suspend fun onSave() {
        execute<Unit> {
            Log.d("Aboba exc", it.toString())
        }.handleThis(getState()) {
            saveProfileDataUseCase.saveData(ProfileMainInfoEntity(username, name, description))
            // some save usecase
            profileReducer.onUsual()
        }
    }

    override fun onDiscard() {
        profileReducer.onUsual()
    }
}