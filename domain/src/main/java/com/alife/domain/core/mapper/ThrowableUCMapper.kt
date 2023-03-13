package com.alife.domain.core.mapper

import com.alife.domain.core.usecase.UseCaseResult

interface ThrowableUCMapper<M> : ThrowableMapper<UseCaseResult<M>>