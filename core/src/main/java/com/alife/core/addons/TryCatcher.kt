package com.alife.core.addons

class TryCatcher<R> {
    suspend fun tryCatch(
        onException: suspend (Exception) -> R,
        onInput: suspend () -> R
    ) = try {
        onInput()
    } catch (e: Exception) {
        onException(e)
    }
}