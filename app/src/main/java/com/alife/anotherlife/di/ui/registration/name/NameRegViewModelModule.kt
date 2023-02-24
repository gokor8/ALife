package com.alife.anotherlife.di.ui.registration.name

import com.alife.anotherlife.ui.screen.registration.name.chain.BaseNameChainValidator
import com.alife.anotherlife.ui.screen.registration.name.chain.NameChainValidator
import com.alife.anotherlife.ui.screen.registration.name.reducer.AbstractNameRegReducer
import com.alife.anotherlife.ui.screen.registration.name.reducer.BaseValidationNameRegReducer
import com.alife.anotherlife.ui.screen.registration.name.reducer.NameRegistrationReducer
import com.alife.anotherlife.ui.screen.registration.name.reducer.NameValidationRegReducer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface NameRegViewModelModule {

    @Binds
    fun bindNameRegReducer(reducer: NameRegistrationReducer): AbstractNameRegReducer

    @Binds
    fun bindNameValidationRegReducer(reducer: NameValidationRegReducer): BaseValidationNameRegReducer

    @Binds
    fun bindNameChainValidator(nameChainValidator: NameChainValidator): BaseNameChainValidator
}