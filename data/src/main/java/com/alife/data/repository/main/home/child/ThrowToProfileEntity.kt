package com.alife.data.repository.main.home.child

import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.main.home.child.ProfileUseCaseEntity
import com.alife.domain.main.home.child.mapper.BaseThrowToProfileEntity
import javax.inject.Inject

class ThrowToProfileEntity @Inject constructor() : BaseThrowToProfileEntity {
    override fun map(inputModel: Throwable): UseCaseResult<ProfileUseCaseEntity> {
        return UseCaseResult.Fail(inputModel)
    }
}