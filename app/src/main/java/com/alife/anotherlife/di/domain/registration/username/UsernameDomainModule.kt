package com.alife.anotherlife.di.domain.registration.username

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.registration.usecase.username.BaseUsernameUseCase
import com.alife.domain.registration.usecase.username.UsernameReadUseCaseBase
import com.alife.domain.registration.usecase.username.UsernameSaveUseCaseBase
import com.alife.domain.registration.usecase.username.addons.UsernameRegEntity
import com.alife.domain.registration.usecase.username.mapper.ThrowToUsernameRegEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UsernameDomainModule {

    @Binds
    fun bindUsernameReadUseCase(useCase: UsernameReadUseCaseBase): BaseUsernameUseCase.Read

    @Binds
    fun bindUsernameSaveUseCase(useCase: UsernameSaveUseCaseBase): BaseUsernameUseCase.Save

    @Binds
    fun bindUsernameThrowMapper(throwMapper: ThrowToUsernameRegEntity): ThrowableMapper<UsernameRegEntity>
}