package com.alife.anotherlife.di.ui.registration.username

import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducerBase
import com.alife.anotherlife.ui.screen.registration.username.reducer.UsernameRegistrationReducerBase
import com.alife.anotherlife.ui.screen.registration.username.reducer.UsernameValidationRegReducerBase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UsernameRegViewModelModule {

    @UsernameAnnotation.UsernameRegistration
    @Binds
    fun bindUsernameRegReducer(reducer: UsernameRegistrationReducerBase): RegistrationReducerBase

    @UsernameAnnotation.UsernameValidation
    @Binds
    fun bindUsernameValidationRegReducer(reducer: UsernameValidationRegReducerBase): BaseValidationRegReducer
}