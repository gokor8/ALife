package com.alife.anotherlife.ui.screen.main.create_alife.mapper

import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BaseCameraPictureScreenState
import com.alife.domain.main.create_alife.picture.entity.SaveImageEntity

interface BaseCameraStateToSaveImage {

    fun map(inputModel: BaseCameraPictureScreenState, imageByteArray: ByteArray): SaveImageEntity
}