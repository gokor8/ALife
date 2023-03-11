package com.alife.domain.registration.usecase.base

import com.alife.domain.registration.core.entity.BoxerRegEntity

sealed interface BaseBaseRegUseCase<M : BoxerRegEntity> : BaseRegStageUseCase {

    interface Read<M : BoxerRegEntity> : BaseBaseRegUseCase<M> {
        suspend fun readData(): M
    }

    interface Save<M : BoxerRegEntity> : BaseBaseRegUseCase<M> {
        suspend fun saveData(inputData: String)
    }
}