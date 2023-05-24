package com.alife.domain.registration.usecase.reg_log.email.save_read.entity

import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.usecase.base.entity.ReadBoxRegEntity

class EmailReadBoxEntity(
    useCaseResult: UseCaseResult<EmailRegEntity>
) : ReadBoxRegEntity<EmailRegEntity>(useCaseResult)