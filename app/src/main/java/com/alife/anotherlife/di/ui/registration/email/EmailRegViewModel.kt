package com.alife.anotherlife.di.ui.registration.email

import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducerBase
import com.alife.anotherlife.ui.screen.registration.email.reducer.EmailRegValidationReducerBase
import com.alife.anotherlife.ui.screen.registration.email.reducer.EmailRegistrationReducerBase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface EmailRegViewModel {

    @EmailAnnotation.EmailRegistration
    @Binds
    fun bindEmailRegReducer(reducer: EmailRegistrationReducerBase): RegistrationReducerBase

    @EmailAnnotation.EmailValidation
    @Binds
    fun bindEmailValidationRegReducer(
        reducer: EmailRegValidationReducerBase
    ): BaseValidationRegReducer
}