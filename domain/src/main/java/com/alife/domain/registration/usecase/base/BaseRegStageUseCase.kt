package com.alife.domain.registration.usecase.base

import com.alife.core.usecase.UseCase
import com.alife.domain.registration.core.entity.BoxRegEntity

sealed interface BaseRegStageUseCase<M : BoxRegEntity> : UseCase {

    interface Read<M : BoxRegEntity> : BaseRegStageUseCase<M> {
        suspend fun readData(): M
    }

    interface Save<M : BoxRegEntity> : BaseRegStageUseCase<M> {
        suspend fun saveData(inputData: String)
    }
}