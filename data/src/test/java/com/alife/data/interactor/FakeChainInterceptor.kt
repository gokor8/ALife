package com.alife.data.interactor

import com.alife.data.core.TestModelContainer
import okhttp3.Call
import okhttp3.Connection
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import java.util.concurrent.TimeUnit

class FakeChainInterceptor(
    private val link: String = "test",
    private val responseCode: Int = 200,
    private val proceedException: Exception? = null
) : Interceptor.Chain {

    private val baseUrl = "http:test.com/"

    override fun request() = Request.Builder().url(baseUrl + link).build()

    override fun proceed(request: Request): Response {
        proceedException?.let { throw it }
        return Response.Builder()
            .request(request)
            .protocol(Protocol.HTTP_1_0)
            .code(responseCode)
            .message("")
            .build()
    }

    override fun connection(): Connection? {
        TODO("Not yet implemented")
    }

    override fun call(): Call {
        TODO("Not yet implemented")
    }

    override fun connectTimeoutMillis(): Int {
        TODO("Not yet implemented")
    }

    override fun withConnectTimeout(timeout: Int, unit: TimeUnit): Interceptor.Chain {
        TODO("Not yet implemented")
    }

    override fun readTimeoutMillis(): Int {
        TODO("Not yet implemented")
    }

    override fun withReadTimeout(timeout: Int, unit: TimeUnit): Interceptor.Chain {
        TODO("Not yet implemented")
    }

    override fun writeTimeoutMillis(): Int {
        TODO("Not yet implemented")
    }

    override fun withWriteTimeout(timeout: Int, unit: TimeUnit): Interceptor.Chain {
        TODO("Not yet implemented")
    }
}