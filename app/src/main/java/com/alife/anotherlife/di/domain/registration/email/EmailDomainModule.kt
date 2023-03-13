package com.alife.anotherlife.di.domain.registration.email

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.registration.usecase.email.send_reg_data.BaseSendRegDataUseCase
import com.alife.domain.registration.usecase.email.RegDataState
import com.alife.domain.registration.usecase.email.send_reg_data.SendRegDataUseCase
import com.alife.domain.registration.usecase.email.send_reg_data.ThrowToRegDataState
import com.alife.domain.registration.usecase.email.save_read.BaseEmailUseCase
import com.alife.domain.registration.usecase.email.save_read.EmailReadRegStageUC
import com.alife.domain.registration.usecase.email.save_read.EmailSaveRegStageUC
import com.alife.domain.registration.usecase.email.save_read.entity.EmailRegEntity
import com.alife.domain.registration.usecase.email.save_read.mapper.ThrowToEmailRegEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface EmailDomainModule {

    @Binds
    fun bindEmailReadUseCase(useCase: EmailReadRegStageUC): BaseEmailUseCase.Read

    @Binds
    fun bindEmailSaveUseCase(useCase: EmailSaveRegStageUC): BaseEmailUseCase.Save

    @Binds
    fun bindEmailThrowMapper(throwMapper: ThrowToEmailRegEntity): ThrowableMapper<EmailRegEntity>

    @Binds
    fun bindSendRegDataUseCase(useCase: SendRegDataUseCase): BaseSendRegDataUseCase

    @Binds
    fun bindSendRegDataThrowMapper(throwMapper: ThrowToRegDataState): ThrowableMapper<RegDataState>
}