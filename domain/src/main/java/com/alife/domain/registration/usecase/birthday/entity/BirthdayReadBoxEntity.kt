package com.alife.domain.registration.usecase.birthday.entity

import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.usecase.base.entity.ReadBoxRegEntity

class BirthdayReadBoxEntity(
    useCaseResult: UseCaseResult<BirthdayRegEntity>
) : ReadBoxRegEntity<BirthdayRegEntity>(useCaseResult)