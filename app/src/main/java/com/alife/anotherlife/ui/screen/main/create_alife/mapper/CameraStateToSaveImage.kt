package com.alife.anotherlife.ui.screen.main.create_alife.mapper

import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.CameraFirstScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BaseCameraPictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.CameraSecondScreenState
import com.alife.domain.core.MappingException
import com.alife.domain.main.create_alife.picture.entity.SaveImageEntity
import javax.inject.Inject

class CameraStateToSaveImage @Inject constructor(): BaseCameraStateToSaveImage {

    override fun map(
        inputModel: BaseCameraPictureScreenState,
        imageByteArray: ByteArray
    ): SaveImageEntity {
        return when(inputModel) {
            is CameraFirstScreenState -> SaveImageEntity.FrontSaveImageEntity(imageByteArray)
            is CameraSecondScreenState -> SaveImageEntity.BackSaveImageEntity(imageByteArray)
            else -> throw MappingException()
        }
    }
}