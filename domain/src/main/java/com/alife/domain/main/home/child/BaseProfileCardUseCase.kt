package com.alife.domain.main.home.child

interface BaseProfileCardUseCase {

    suspend fun getProfileCards(): ProfileUseCaseEntity
}