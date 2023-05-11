package com.alife.anotherlife.di.ui.registration.name

import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducerBase
import com.alife.anotherlife.ui.screen.registration.name.chain.AccessCharsInputTextChain
import com.alife.anotherlife.ui.screen.registration.name.chain.InputRegTextChain
import com.alife.anotherlife.ui.screen.registration.name.reducer.NameRegistrationReducerBase
import com.alife.anotherlife.ui.screen.registration.name.reducer.NameValidationRegReducerBase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface NameRegViewModelModule {

    @NameAnnotation.NameRegistration
    @Binds
    fun bindNameRegReducer(reducer: NameRegistrationReducerBase): RegistrationReducerBase

    @NameAnnotation.NameValidation
    @Binds
    fun bindNameValidationRegReducer(reducer: NameValidationRegReducerBase): BaseValidationRegReducer

    // Chain
    @Binds
    fun bindAccessCharsNameTextChain(chain: AccessCharsInputTextChain): InputRegTextChain
}