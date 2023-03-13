package com.alife.domain.registration.usecase.base

import com.alife.core.usecase.UseCase
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.core.entity.BoxRegEntity

sealed interface BaseRegStageUseCase<M> : UseCase {

    interface Read<M> : BaseRegStageUseCase<M> {
        suspend fun readData(): UseCaseResult<M>
    }

    interface Save<M> : BaseRegStageUseCase<M> {
        suspend fun saveData(inputData: String)
    }
}