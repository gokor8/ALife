package com.alife.anotherlife.ui.screen.main.create_alife.reducer_photo

import com.alife.anotherlife.ui.screen.main.create_alife.mapper.BaseCameraStateToSaveImage
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BasePictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.PictureScreenState
import com.alife.domain.main.create_alife.picture.entity.SaveImageEntity

class FakeCameraStateToSaveImage : BaseCameraStateToSaveImage {

    // Fake Realization
    class FakeSaveImageEntity : SaveImageEntity(ByteArray(0))

    override fun map(
        inputModel: BasePictureScreenState,
        imageByteArray: ByteArray
    ): SaveImageEntity = FakeSaveImageEntity()
}