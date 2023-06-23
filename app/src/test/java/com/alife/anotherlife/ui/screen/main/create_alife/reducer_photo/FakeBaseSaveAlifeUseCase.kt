package com.alife.anotherlife.ui.screen.main.create_alife.reducer_photo

import com.alife.domain.main.create_alife.picture.BaseSaveAlifeUseCase
import com.alife.domain.main.create_alife.picture.entity.SaveImageEntity

class FakeSaveAlifeUseCase(private val exception: Exception? = null) : BaseSaveAlifeUseCase {

    override suspend fun saveImage(saveImageEntity: SaveImageEntity) {
        exception?.apply { throw this }
    }
}