package com.alife.anotherlife.di.domain.registration.username

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.registration.usecase.reg_log.username.BaseUsernameUseCase
import com.alife.domain.registration.usecase.reg_log.username.UsernameReadRegStageUC
import com.alife.domain.registration.usecase.reg_log.username.UsernameSaveRegStageUC
import com.alife.domain.registration.usecase.reg_log.username.addons.UsernameRegEntity
import com.alife.domain.registration.usecase.reg_log.username.mapper.ThrowToUsernameRegEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UsernameDomainModule {

    @Binds
    fun bindUsernameReadUseCase(useCase: UsernameReadRegStageUC): BaseUsernameUseCase.Read

    @Binds
    fun bindUsernameSaveUseCase(useCase: UsernameSaveRegStageUC): BaseUsernameUseCase.Save

    @Binds
    fun bindUsernameThrowMapper(throwMapper: ThrowToUsernameRegEntity): ThrowableUCMapper<UsernameRegEntity>
}