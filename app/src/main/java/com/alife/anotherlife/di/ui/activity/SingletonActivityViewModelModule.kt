package com.alife.anotherlife.di.ui.activity

import com.alife.anotherlife.ui.activity.BaseMainActivityReducer
import com.alife.anotherlife.ui.activity.MainActivityReducer
import com.alife.anotherlife.ui.activity.mapper.BaseCloudExceptionToActivityState
import com.alife.anotherlife.ui.activity.mapper.CloudExceptionToActivityState
import com.alife.domain.core.exception_global.CommonExceptionHandler
import com.alife.domain.core.exception_global.GlobalExceptionHandler
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface SingletonActivityViewModelModule {

    @Reusable
    @Binds
    fun bindsReducer(reducer: MainActivityReducer): BaseMainActivityReducer

    @Reusable
    @Binds
    fun bindGlobalExceptionHandler(reducer: MainActivityReducer): CommonExceptionHandler

    @Reusable
    @Binds
    fun bindCloudExceptionToActivityState(mapper: CloudExceptionToActivityState)
            : BaseCloudExceptionToActivityState
}