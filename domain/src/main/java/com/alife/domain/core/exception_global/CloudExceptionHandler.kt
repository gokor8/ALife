package com.alife.domain.core.exception_global

interface CloudExceptionHandler {

    fun handle(exception: Throwable)
}