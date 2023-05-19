package com.alife.data.interceptor

// TODO MainActivity uiStore отнаследовать от него
// TODO либо не uiStore а другое что-то, редюсер например
interface GlobalExceptionHandler {

    fun handle(exception: GlobalException)
}