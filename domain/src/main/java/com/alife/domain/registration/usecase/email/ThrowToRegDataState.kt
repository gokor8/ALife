package com.alife.domain.registration.usecase.email

import com.alife.domain.core.mapper.ThrowableMapper
import javax.inject.Inject

class ThrowToRegDataState @Inject constructor() : ThrowableMapper<RegDataState> {

    override fun map(inputModel: Throwable): RegDataState {
        return RegDataState.Fail()
    }
}