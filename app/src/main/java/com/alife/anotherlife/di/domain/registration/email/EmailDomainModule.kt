package com.alife.anotherlife.di.domain.registration.email

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.registration.usecase.email.BaseEmailUseCase
import com.alife.domain.registration.usecase.email.EmailReadBaseRegUseCase
import com.alife.domain.registration.usecase.email.EmailSaveBaseRegUseCase
import com.alife.domain.registration.usecase.email.entity.EmailRegEntity
import com.alife.domain.registration.usecase.email.mapper.ThrowToEmailRegEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface EmailDomainModule {

    @Binds
    fun bindEmailReadUseCase(useCase: EmailReadBaseRegUseCase): BaseEmailUseCase.Read

    @Binds
    fun bindEmailSaveUseCase(useCase: EmailSaveBaseRegUseCase): BaseEmailUseCase.Save

    @Binds
    fun bindEmailThrowMapper(throwMapper: ThrowToEmailRegEntity): ThrowableMapper<EmailRegEntity>
}