package com.alife.anotherlife.di.domain.registration.email

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.registration.usecase.email.save_read.BaseEmailUseCase
import com.alife.domain.registration.usecase.email.save_read.EmailReadRegStageUC
import com.alife.domain.registration.usecase.email.save_read.EmailSaveRegRegStageUC
import com.alife.domain.registration.usecase.email.save_read.entity.EmailRegEntity
import com.alife.domain.registration.usecase.email.save_read.mapper.ThrowToEmailRegEntity
import com.alife.domain.registration.usecase.email.send_reg_data.*
import com.alife.domain.registration.usecase.email.send_reg_data.mapper.UCResultToEntityMapper
import com.alife.domain.registration.usecase.email.send_reg_data.mapper.UCResultToEntityToSuccess
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
    fun bindSendRegDataUseCase(useCase: SendRegDataUseCaseResult): BaseSendRegDataUseCase

    @Binds
    fun bindRegDataFacadeUseCase(useCase: RegDataFacadeUseCase): BaseRegDataFacadeUseCase

    @Binds
    fun bindUCResultToEntityToSuccess(mapper: UCResultToEntityToSuccess): UCResultToEntityMapper

    @Binds
    fun bindSendRegDataThrowMapper(throwMapper: ThrowToRegDataState): ThrowableUCMapper<Nothing>
}