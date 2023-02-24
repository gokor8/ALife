package com.alife.anotherlife.di.ui.registration.username

import com.alife.anotherlife.di.ui.registration.RegAnnotations
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.username.reducer.AbstractUsernameRegReducer
import com.alife.anotherlife.ui.screen.registration.username.reducer.AbstractUsernameValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.username.reducer.UsernameRegistrationReducer
import com.alife.anotherlife.ui.screen.registration.username.reducer.UsernameValidationRegReducer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UsernameRegViewModelModule {

    @Binds
    fun bindUsernameRegReducer(reducer: UsernameRegistrationReducer): AbstractUsernameRegReducer

    @RegAnnotations.UsernameValidationReducer
    @Binds
    fun bindUsernameValidationRegReducer(reducer: UsernameValidationRegReducer): AbstractUsernameValidationRegReducer

}