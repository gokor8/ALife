package com.alife.domain.login.registration_stage

import com.alife.domain.core.usecase.UseCaseResult

interface BaseUserRegStageUseCase {

    suspend fun getStage(): UseCaseResult<UseCaseResult.EmptySuccess>
}