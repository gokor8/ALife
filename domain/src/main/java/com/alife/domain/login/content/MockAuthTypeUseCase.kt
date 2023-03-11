package com.alife.domain.login.content

import com.alife.domain.login.content.base.BaseMockAuthTypeUseCase
import com.alife.domain.login.content.entity.MockImageAuthTypeEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class MockAuthTypeUseCase @Inject constructor(
    override val dispatcher: CoroutineDispatcher
) : BaseMockAuthTypeUseCase() {

    override fun getAuthTypes(): List<MockImageAuthTypeEntity> = listOf(
        MockImageAuthTypeEntity.InstagramAuthTypeEntity(),
        MockImageAuthTypeEntity.VKAuthTypeEntity(),
        MockImageAuthTypeEntity.GoogleAuthTypeEntity(),
    )
}