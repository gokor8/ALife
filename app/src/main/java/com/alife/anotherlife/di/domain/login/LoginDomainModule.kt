package com.alife.anotherlife.di.domain.login

import com.alife.domain.registration.usecase.username.BaseUsernameUseCase
import com.alife.domain.registration.usecase.username.UsernameReadRegStageUC
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface LoginDomainModule {

    @Binds
    fun bindUsernameReadUseCase(useCase: UsernameReadRegStageUC): BaseUsernameUseCase.Read
}