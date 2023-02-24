package com.alife.anotherlife.di.ui.registration.name

import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducer
import com.alife.anotherlife.ui.screen.registration.name.reducer.NameRegistrationReducer
import com.alife.anotherlife.ui.screen.registration.name.reducer.NameValidationRegReducer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface NameRegViewModelModule {

    @NameAnnotation.NameRegistration
    @Binds
    fun bindNameRegReducer(reducer: NameRegistrationReducer): RegistrationReducer

    @NameAnnotation.NameValidation
    @Binds
    fun bindNameValidationRegReducer(reducer: NameValidationRegReducer): BaseValidationRegReducer
}