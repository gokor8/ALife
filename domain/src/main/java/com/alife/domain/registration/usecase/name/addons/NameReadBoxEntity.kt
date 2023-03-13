package com.alife.domain.registration.usecase.name.addons

import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.usecase.base.ReadBoxRegEntity

class NameReadBoxEntity(
    useCaseResult: UseCaseResult<NameRegEntity>
) : ReadBoxRegEntity<NameRegEntity>(useCaseResult)