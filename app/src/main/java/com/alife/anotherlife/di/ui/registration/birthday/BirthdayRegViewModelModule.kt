package com.alife.anotherlife.di.ui.registration.birthday

import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducerBase
import com.alife.anotherlife.ui.screen.registration.birthday.reducer.BirthdayRegReducerBase
import com.alife.anotherlife.ui.screen.registration.birthday.reducer.BirthdayValidationRegReducerBase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface BirthdayRegViewModelModule {

    @BirthdayAnnotation.BirthdayRegistration
    @Binds
    fun bindBirthdayRegReducer(reducer: BirthdayRegReducerBase): RegistrationReducerBase

    @BirthdayAnnotation.BirthdayValidation
    @Binds
    fun bindBirthdayValidationRegReducer(
        reducer: BirthdayValidationRegReducerBase
    ): BaseValidationRegReducer
}