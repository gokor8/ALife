package com.alife.domain.login.registration_stage

import com.alife.domain.registration.usecase.base.ReadBoxRegEntity

interface BaseUserRegStageUseCase {

    suspend fun getStage(): ReadBoxRegEntity<*>
}