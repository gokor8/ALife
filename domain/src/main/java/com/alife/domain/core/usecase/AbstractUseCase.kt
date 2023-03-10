package com.alife.domain.core.usecase

import com.alife.core.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher

abstract class AbstractUseCase : UseCase {

    protected abstract val dispatcher: CoroutineDispatcher
}