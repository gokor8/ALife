package com.alife.domain.login.registration_stage

import com.alife.domain.registration.usecase.base.entity.ReadBoxRegEntity

interface BaseUserRegStageUseCase {

    suspend fun getStage(): ReadBoxRegEntity<*>
}