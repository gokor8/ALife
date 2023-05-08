package com.alife.anotherlife.ui.screen.main.create_alife.mapper

import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.CameraFirstScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BasePictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.CameraSecondLoadedScreenState
import com.alife.domain.core.MappingException
import com.alife.domain.main.create_alife.picture.entity.SaveImageEntity
import javax.inject.Inject

class CameraStateToSaveImage @Inject constructor(): BaseCameraStateToSaveImage {

    override fun map(
        inputModel: BasePictureScreenState,
        imageByteArray: ByteArray
    ): SaveImageEntity {
        return when(inputModel) {
            is CameraFirstScreenState -> SaveImageEntity.FrontSaveImageEntity(imageByteArray)
            is CameraSecondLoadedScreenState -> SaveImageEntity.BackSaveImageEntity(imageByteArray)
            else -> throw MappingException()
        }
    }
}