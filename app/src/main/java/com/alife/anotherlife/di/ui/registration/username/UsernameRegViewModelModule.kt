package com.alife.anotherlife.di.ui.registration.username

import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducer
import com.alife.anotherlife.ui.screen.registration.username.reducer.UsernameRegistrationReducer
import com.alife.anotherlife.ui.screen.registration.username.reducer.UsernameValidationRegReducer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UsernameRegViewModelModule {

    @UsernameAnnotation.UsernameRegistration
    @Binds
    fun bindUsernameRegReducer(reducer: UsernameRegistrationReducer): RegistrationReducer

    @UsernameAnnotation.UsernameValidation
    @Binds
    fun bindUsernameValidationRegReducer(reducer: UsernameValidationRegReducer): BaseValidationRegReducer
}