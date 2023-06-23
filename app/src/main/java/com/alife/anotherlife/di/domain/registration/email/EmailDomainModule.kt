package com.alife.anotherlife.di.domain.registration.email

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.registration.usecase.reg_log.email.save_read.BaseEmailUseCase
import com.alife.domain.registration.usecase.reg_log.email.save_read.EmailReadRegStageUC
import com.alife.domain.registration.usecase.reg_log.email.save_read.EmailSaveRegRegStageUC
import com.alife.domain.registration.usecase.reg_log.email.save_read.entity.EmailRegEntity
import com.alife.domain.registration.usecase.reg_log.email.save_read.mapper.ThrowToEmailRegEntity
import com.alife.domain.registration.usecase.reg_log.email.send_reg_data.BaseRegDataFacadeUseCase
import com.alife.domain.registration.usecase.reg_log.email.send_reg_data.BaseSendRegDataUseCase
import com.alife.domain.registration.usecase.reg_log.email.send_reg_data.RegDataFacadeUseCase
import com.alife.domain.registration.usecase.reg_log.email.send_reg_data.SendRegDataUseCase
import com.alife.domain.registration.usecase.reg_log.email.send_reg_data.ThrowToRegData
import com.alife.domain.registration.usecase.reg_log.email.send_reg_data.mapper.BaseThrowToRegData
import com.alife.domain.registration.usecase.reg_log.email.send_reg_data.mapper.UCResultToEntityMapper
import com.alife.domain.registration.usecase.reg_log.email.send_reg_data.mapper.UCResultToEntityToSuccess
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
    fun bindEmailSaveUseCase(useCase: EmailSaveRegRegStageUC): BaseEmailUseCase.Save

    @Binds
    fun bindEmailThrowMapper(throwMapper: ThrowToEmailRegEntity): ThrowableUCMapper<EmailRegEntity>

    @Binds
    fun bindSendRegDataUseCase(useCase: SendRegDataUseCase): BaseSendRegDataUseCase

    @Binds
    fun bindRegDataFacadeUseCase(useCase: RegDataFacadeUseCase): BaseRegDataFacadeUseCase

    @Binds
    fun bindUCResultToEntityToSuccess(mapper: UCResultToEntityToSuccess): UCResultToEntityMapper

    @Binds
    fun bindSendRegDataThrowMapper(throwMapper: ThrowToRegData): BaseThrowToRegData
}