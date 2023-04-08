package com.alife.anotherlife.ui.screen.main.create_alife.mapper

import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraScreenState
import com.alife.domain.main.create_alife.entity.SaveImageEntity

interface BaseCameraStateToSaveImage {

    fun map(inputModel: CameraScreenState, imageByteArray: ByteArray): SaveImageEntity
}