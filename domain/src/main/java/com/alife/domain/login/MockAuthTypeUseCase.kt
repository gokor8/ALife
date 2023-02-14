package com.alife.domain.login

import com.alife.domain.login.base.BaseMockAuthTypeUseCase
import com.alife.domain.login.entity.AuthTypeEntity
import com.alife.domain.login.entity.MockImageAuthTypeEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MockAuthTypeUseCase @Inject constructor(
    override val dispatcher: CoroutineDispatcher
) : BaseMockAuthTypeUseCase() {

    override fun getAuthTypes(): List<AuthTypeEntity> = listOf(
        MockImageAuthTypeEntity.InstagramAuthTypeEntity(),
        MockImageAuthTypeEntity.VKAuthTypeEntity(),
        MockImageAuthTypeEntity.GoogleAuthTypeEntity(),
    )
}