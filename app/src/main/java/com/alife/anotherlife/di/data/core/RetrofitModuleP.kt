package com.alife.anotherlife.di.data.core

import com.alife.data.interceptor.DefaultRequestInterceptor
import com.alife.data.interceptor.TokenReAuthInterceptor
import com.alife.data.interceptor.model.RetrofitAnnotation
import com.alife.data.services.RegistrationService
import com.alife.data.services.UploadService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@Module
@InstallIn(SingletonComponent::class)
class RetrofitModuleP {

    @RetrofitAnnotation.BaseUrl
    @Provides
    fun provideBaseUrl(): String = "http://10.0.2.2:8080/"//"http://127.0.0.1:8080/"

    @Provides
    fun provideHttpLoginInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
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
        .readTimeout(2, TimeUnit.MINUTES)
        .connectTimeout(1, TimeUnit.MINUTES)
        .build()

    @Provides
    fun provideRetrofit(
        @RetrofitAnnotation.BaseUrl
        baseUrl: String,
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideRegistrationService(retrofit: Retrofit): RegistrationService =
        retrofit.create(RegistrationService::class.java)

    @Provides
    fun provideUploadService(retrofit: Retrofit): UploadService =
        retrofit.create(UploadService::class.java)
}