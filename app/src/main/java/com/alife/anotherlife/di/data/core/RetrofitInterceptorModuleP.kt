package com.alife.anotherlife.di.data.core

import com.alife.data.interceptor.mapper.BaseRequestToAuthHeader
import com.alife.data.interceptor.mapper.RequestToAuthHeader
import com.alife.data.interceptor.model.BaseTokenErrorChain
import com.alife.data.interceptor.model.RefreshTokenErrorChain
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RetrofitInterceptorModuleP {

    @Binds
    fun bindTokenErrorChain(errorChain: RefreshTokenErrorChain): BaseTokenErrorChain

    @Binds
    fun bindRequestToAuthHeader(mapper: RequestToAuthHeader): BaseRequestToAuthHeader
}