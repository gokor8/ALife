package com.alife.anotherlife.di.core

import com.alife.domain.core.coroutine_await_list.BaseCoroutineAwaitList
import com.alife.domain.core.coroutine_await_list.CoroutineAwaitList
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CoroutineP {

    @Provides
    fun coroutineAwaitList(): BaseCoroutineAwaitList = CoroutineAwaitList()
}