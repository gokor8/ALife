package com.alife.anotherlife.di.ui.main.map

import com.alife.anotherlife.ui.screen.main.navigation_bar.map.BaseMapReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.MapReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.mapper.BaseMapPostEntityToUI
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.mapper.MapPostEntityToUI
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface MapViewModelModule {

    @Binds
    fun bindMapReducer(reducer: MapReducer): BaseMapReducer

    @Binds
    fun bindMapPostEntityToUI(mapper: MapPostEntityToUI): BaseMapPostEntityToUI
}