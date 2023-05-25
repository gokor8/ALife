package com.alife.domain.core.exception_global

// TODO MainActivity uiStore отнаследовать от него
// TODO либо не uiStore а другое что-то, редюсер например
interface GlobalExceptionHandler {

    fun handle(exception: GlobalException)
}

interface CommonExceptionHandler : GlobalExceptionHandler, CloudExceptionHandler