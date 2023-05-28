package com.alife.domain.main.home.child.child_friends

import com.alife.domain.main.home.child.BaseProfileCardUseCase
import com.alife.domain.main.home.child.ProfileUseCaseEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject


interface BaseFriendsProfileCardUC : BaseProfileCardUseCase

class FriendsProfileCardUC @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
) : BaseFriendsProfileCardUC {

    override suspend fun getProfileCards(): ProfileUseCaseEntity {
        return withContext(dispatcher) { ProfileUseCaseEntity(emptyList()) }
    }
}