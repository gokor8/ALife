package com.alife.anotherlife.ui.screen.main.create_alife.reducer_photo

import com.alife.anotherlife.ui.screen.main.create_alife.mapper.BaseCameraStateToSaveImage
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BaseCameraPictureScreenState
import com.alife.domain.main.create_alife.picture.entity.SaveImageEntity

class FakeCameraStateToSaveImage : BaseCameraStateToSaveImage {

    override fun map(
        inputModel: BaseCameraPictureScreenState,
        imageByteArray: ByteArray
    ): SaveImageEntity = FakeSaveImageEntity()


    // Fake Realization
    class FakeSaveImageEntity : SaveImageEntity(ByteArray(0))
}