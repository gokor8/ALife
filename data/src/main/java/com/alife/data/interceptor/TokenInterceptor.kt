package com.alife.data.interceptor

import com.alife.domain.registration.usecase.token.BaseTokensUseCase
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import java.net.HttpURLConnection
import javax.inject.Inject

class TokenInterceptor@Inject constructor(
    private val tokensUseCase: BaseTokensUseCase
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        runBlocking {
            val tokens = tokensUseCase.getTokens()

        }
        val accessToken = sharedPreferences.accessToken
        val tokenIsOverdue = sharedPreferences.isTokenOverdue
        val request = chain.request()
        return try {
            if (accessToken != "" && !tokenIsOverdue) {
                chain.proceed(
                    request
                        .newBuilder()
                        .addHeader("Authorization", "Bearer $accessToken")
                        .addHeader("Accept", "*/*")
                        .build()
                )
            } else if (tokenIsOverdue) {
                chain.proceed(
                    request
                        .newBuilder()
                        .addHeader("Accept", "*/*")
                        .build()
                )
            } else {
                chain.proceed(request)
            }
        } catch (e: Exception) {
            val message = e.message
            e.printStackTrace()
            Response.Builder()
                .body((message ?: "").toResponseBody("-".toMediaTypeOrNull()))
                .protocol(Protocol.HTTP_2)
                .code(HttpURLConnection.HTTP_NOT_FOUND)
                .request(request)
                .message(message ?: "")
                .build()
        }
    }
}
