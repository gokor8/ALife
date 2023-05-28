package com.alife.anotherlife.di.domain.registration.email_code

import com.alife.domain.registration.usecase.reg_log.email_code.BaseEmailCodeUseCase
import com.alife.domain.registration.usecase.reg_log.email_code.EmailCodeUseCaseResult
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface EmailCodeDomainModule {

    @Binds
    fun bindEmailCodeUseCaseResult(useCase: EmailCodeUseCaseResult): BaseEmailCodeUseCase
}