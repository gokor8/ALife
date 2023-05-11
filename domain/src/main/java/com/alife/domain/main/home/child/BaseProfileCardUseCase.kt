package com.alife.domain.main.home.child

import com.alife.domain.core.usecase.UseCaseResult

interface BaseProfileCardUseCase {

    suspend fun getProfileCards(): UseCaseResult<ProfileUseCaseEntity>
}