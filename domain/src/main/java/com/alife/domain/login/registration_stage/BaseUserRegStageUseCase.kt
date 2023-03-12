package com.alife.domain.login.registration_stage

import com.alife.domain.registration.core.entity.BoxRegEntity

interface BaseUserRegStageUseCase {

    suspend fun getStage(): BoxRegEntity
}