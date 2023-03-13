package com.alife.domain.registration.usecase.base.entity

import com.alife.core.usecase.UseCaseEntity
import com.alife.domain.core.usecase.UseCaseResult

abstract class ReadBoxRegEntity<M>(val useCaseResult: UseCaseResult<M>) : UseCaseEntity