package com.alife.domain.registration.usecase.base

import com.alife.core.usecase.UseCase
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.usecase.base.entity.ReadBoxRegEntity

sealed interface BaseRegStageUseCase<out M> : UseCase {

    interface Read<out M> : BaseRegStageUseCase<M> {
        suspend fun readData(): UseCaseResult<M>
    }

    interface ReadBox<M> : BaseRegStageUseCase<M> {
        suspend fun readAndBox(): ReadBoxRegEntity<M>
    }

    interface Save<M> : BaseRegStageUseCase<M> {
        suspend fun saveData(inputData: String)
    }
}