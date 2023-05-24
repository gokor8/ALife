package com.alife.domain.registration.usecase.reg_log.username.addons

import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.usecase.base.entity.ReadBoxRegEntity

class UsernameReadBoxEntity(
    useCaseResult: UseCaseResult<UsernameRegEntity>
) : ReadBoxRegEntity<UsernameRegEntity>(useCaseResult)