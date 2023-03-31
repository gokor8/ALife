package com.alife.anotherlife.di.ui.main.create_alife

import com.alife.anotherlife.ui.screen.main.create_alife.BaseCreateAlifeReducer
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeReducer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface CreateAlifeViewModelModule {

    @Binds
    fun bindCreateAlifeReducer(reducer: CreateAlifeReducer): BaseCreateAlifeReducer
}