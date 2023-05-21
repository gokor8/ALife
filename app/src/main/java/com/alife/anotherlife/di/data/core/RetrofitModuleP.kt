package com.alife.anotherlife.di.data.core

import com.alife.data.interceptor.DefaultRequestInterceptor
import com.alife.data.interceptor.TokenReAuthInterceptor
import com.alife.data.services.RegistrationService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


@Module
@InstallIn(SingletonComponent::class)
class RetrofitModuleP {

    @Provides
    fun provideHttpLoginInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.HEADERS
    }

    @Provides
    fun provideGson(): Gson = Gson()

    @Provides
    fun provideOkhttp(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        defaultRequestInterceptor: DefaultRequestInterceptor,
        tokenReAuthInterceptor: TokenReAuthInterceptor
    ): OkHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(tokenReAuthInterceptor)
        .addInterceptor(defaultRequestInterceptor)
        .build()

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("http://127.0.0.1:8080/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideRegistrationService(retrofit: Retrofit): RegistrationService =
        retrofit.create(RegistrationService::class.java)
}