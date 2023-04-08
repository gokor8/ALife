package com.alife.domain.main.create_alife

import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.main.create_alife.entity.SaveImageEntity

interface BaseSaveAlifeUseCase {

    suspend fun saveImage(saveImageEntity: SaveImageEntity): UseCaseResult<Unit>
}