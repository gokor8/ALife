package com.alife.anotherlife.di.data.core

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
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


@Module
@InstallIn(SingletonComponent::class)
class RetrofitModuleP {

    @Provides
    fun provideGson(): Gson = Gson()

    @Provides
    fun provideOkhttp(): OkHttpClient = OkHttpClient().newBuilder().addInterceptor(Interceptor { chain ->
        val originalRequest: Request = chain.request()
        val builder: Request.Builder = originalRequest.newBuilder().header(
            "Authorization",
            Credentials.basic("aUsername", "aPassword")
        )
        val newRequest: Request = builder.build()
        chain.proceed(newRequest)
    }).build();

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