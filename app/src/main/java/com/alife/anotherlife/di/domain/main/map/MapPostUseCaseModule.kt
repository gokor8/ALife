package com.alife.anotherlife.di.domain.main.map

import com.alife.domain.main.map.BaseMapPostUseCase
import com.alife.domain.main.map.MapPostUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface MapPostUseCaseModule {

    @Binds
    fun bindMapPostUseCase(useCase: MapPostUseCase): BaseMapPostUseCase
}