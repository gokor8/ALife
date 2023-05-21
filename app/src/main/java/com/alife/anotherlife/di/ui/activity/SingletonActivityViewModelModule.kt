package com.alife.anotherlife.di.ui.activity

import com.alife.anotherlife.ui.activity.BaseMainActivityReducer
import com.alife.anotherlife.ui.activity.MainActivityReducer
import com.alife.domain.core.exception_global.GlobalExceptionHandler
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface SingletonActivityViewModelModule {

    @Binds
    fun bindsReducer(reducer: MainActivityReducer): BaseMainActivityReducer


    @Binds
    fun bindGlobalExceptionHandler(reducer: MainActivityReducer): GlobalExceptionHandler
}