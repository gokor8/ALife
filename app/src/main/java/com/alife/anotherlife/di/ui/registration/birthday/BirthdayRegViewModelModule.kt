package com.alife.anotherlife.di.ui.registration.birthday

import com.alife.anotherlife.ui.screen.registration.base.chain.EmptyTextChain
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducer
import com.alife.anotherlife.ui.screen.registration.birthday.reducer.BirthdayRegReducer
import com.alife.anotherlife.ui.screen.registration.birthday.reducer.BirthdayValidationRegReducer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
interface BirthdayRegViewModelModule {

    @BirthdayAnnotation.BirthdayRegistration
    @Binds
    fun bindBirthdayRegReducer(reducer: BirthdayRegReducer): RegistrationReducer

    @BirthdayAnnotation.BirthdayValidation
    @Binds
    fun bindBirthdayValidationRegReducer(
        reducer: BirthdayValidationRegReducer
    ): BaseValidationRegReducer
}