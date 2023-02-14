package com.alife.anotherlife.di.core

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class Dispatchers {

    @Provides
    fun dispatchersIO(): CoroutineDispatcher = Dispatchers.IO
}