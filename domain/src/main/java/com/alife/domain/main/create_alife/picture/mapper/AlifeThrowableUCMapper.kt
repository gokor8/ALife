package com.alife.domain.main.create_alife.picture.mapper

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.main.create_alife.picture.entity.FailFileNotFound
import java.io.FileNotFoundException
import javax.inject.Inject

class AlifeThrowableUCMapper @Inject constructor() : ThrowableUCMapper<Unit> {
    override fun map(inputModel: Throwable): UseCaseResult<Unit> {
        return when(inputModel) {
            is FileNotFoundException -> FailFileNotFound()
            else -> UseCaseResult.Fail(inputModel)
        }
    }
}