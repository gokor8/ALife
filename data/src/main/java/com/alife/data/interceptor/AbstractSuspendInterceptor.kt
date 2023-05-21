package com.alife.data.interceptor

import com.alife.domain.core.exception_global.GlobalException
import com.alife.domain.core.exception_global.GlobalExceptionHandler
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response
import java.lang.Exception

abstract class AbstractSuspendInterceptor(
    private val globalExceptionHandler: GlobalExceptionHandler
) : Interceptor {

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Pre Global Exception $exception")

        if (exception is GlobalException) globalExceptionHandler.handle(exception)
    }

    override fun intercept(chain: Chain) = try {
        runBlocking(exceptionHandler) {
            suspendIntercept(chain)
        }
    } catch (e: Exception) {
        chain.proceed(chain.request())
    }

    protected abstract suspend fun suspendIntercept(chain: Chain): Response
}