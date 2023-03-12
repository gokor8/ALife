package com.alife.anotherlife.di.ui.registration.email_code

import com.alife.anotherlife.ui.screen.registration.email_code.reducer.BaseEmailCodeRegReducer
import com.alife.anotherlife.ui.screen.registration.email_code.reducer.EmailCodeRegReducer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface EmailCodeRegViewModel {

    @Binds
    fun bindEmailRegReducer(reducer: EmailCodeRegReducer): BaseEmailCodeRegReducer
}