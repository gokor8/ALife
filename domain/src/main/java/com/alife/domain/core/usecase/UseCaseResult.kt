package com.alife.domain.core.usecase

import com.alife.core.usecase.UseCaseEntity

interface UseCaseResult<out M> : UseCaseEntity {

    interface BaseSuccess<out M> : UseCaseResult<M>

    interface BaseFail<out M> : UseCaseResult<M>


    class Success<M>(val model: M) : BaseSuccess<M>
    class EmptySuccess : BaseSuccess<Nothing>

    class Fail(val exception: Throwable) : BaseFail<Nothing>
    class EmptyFail() : BaseFail<Nothing>
}