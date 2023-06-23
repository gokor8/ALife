package com.alife.anotherlife.di.ui.registration.email_code

import com.alife.anotherlife.ui.screen.registration.email_code.mapper.BaseCodeExceptionMapper
import com.alife.anotherlife.ui.screen.registration.email_code.mapper.CodeExceptionMapper
import com.alife.anotherlife.ui.screen.registration.email_code.reducer.AbstractEmailCodeRegReducerBase
import com.alife.anotherlife.ui.screen.registration.email_code.reducer.EmailCodeRegReducerBase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface EmailCodeRegViewModel {

    @Binds
    fun bindEmailRegReducer(reducer: EmailCodeRegReducerBase): AbstractEmailCodeRegReducerBase

    @Binds
    fun bindCodeExceptionMapper(mapper: CodeExceptionMapper): BaseCodeExceptionMapper
}