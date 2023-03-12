package com.alife.anotherlife.di.domain.registration.email

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.registration.usecase.email.BaseSendRegDataUseCase
import com.alife.domain.registration.usecase.email.RegDataState
import com.alife.domain.registration.usecase.email.SendRegDataUseCase
import com.alife.domain.registration.usecase.email.ThrowToRegDataState
import com.alife.domain.registration.usecase.email.save_read.BaseEmailUseCase
import com.alife.domain.registration.usecase.email.save_read.EmailReadRegStageUseCase
import com.alife.domain.registration.usecase.email.save_read.EmailSaveBaseRegStageUseCase
import com.alife.domain.registration.usecase.email.save_read.entity.BoxEmailRegEntity
import com.alife.domain.registration.usecase.email.save_read.mapper.ThrowToEmailRegEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface EmailDomainModule {

    @Binds
    fun bindEmailReadUseCase(useCase: EmailReadRegStageUseCase): BaseEmailUseCase.Read

    @Binds
    fun bindEmailSaveUseCase(useCase: EmailSaveBaseRegStageUseCase): BaseEmailUseCase.Save

    @Binds
    fun bindEmailThrowMapper(throwMapper: ThrowToEmailRegEntity): ThrowableMapper<BoxEmailRegEntity>

    @Binds
    fun bindSendRegDataUseCase(useCase: SendRegDataUseCase): BaseSendRegDataUseCase

    @Binds
    fun bindSendRegDataThrowMapper(throwMapper: ThrowToRegDataState): ThrowableMapper<RegDataState>
}