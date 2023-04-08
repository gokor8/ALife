package com.alife.anotherlife.ui.screen.main.create_alife.mapper

import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraFirstScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraSecondScreenState
import com.alife.domain.core.MappingException
import com.alife.domain.main.create_alife.entity.SaveImageEntity
import javax.inject.Inject

class CameraStateToSaveImage @Inject constructor(): BaseCameraStateToSaveImage {

    override fun map(
        inputModel: CameraScreenState,
        imageByteArray: ByteArray
    ): SaveImageEntity {
        return when(inputModel) {
            is CameraFirstScreenState -> SaveImageEntity.FrontSaveImageEntity(imageByteArray)
            is CameraSecondScreenState -> SaveImageEntity.BackSaveImageEntity(imageByteArray)
            else -> throw MappingException()
        }
    }
}