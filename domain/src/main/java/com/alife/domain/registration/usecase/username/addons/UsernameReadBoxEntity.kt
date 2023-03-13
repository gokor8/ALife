package com.alife.domain.registration.usecase.username.addons

import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.usecase.base.ReadBoxRegEntity

class UsernameReadBoxEntity(
    useCaseResult: UseCaseResult<UsernameRegEntity>
) : ReadBoxRegEntity<UsernameRegEntity>(useCaseResult)