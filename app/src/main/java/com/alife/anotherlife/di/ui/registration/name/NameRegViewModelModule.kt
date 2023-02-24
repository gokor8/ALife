package com.alife.anotherlife.di.ui.registration.name

import com.alife.anotherlife.di.ui.registration.RegAnnotations
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.chain.RegTextTextChain
import com.alife.anotherlife.ui.screen.registration.name.reducer.AbstractNameRegReducer
import com.alife.anotherlife.ui.screen.registration.name.reducer.AbstractNameValidationRegReducer
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

    @RegAnnotations.NameValidationReducer
    @Binds
    fun bindNameValidationRegReducer(reducer: NameValidationRegReducer): AbstractNameValidationRegReducer

    @Binds
    fun bindNameChainValidator(nameChainValidator: RegTextTextChain): BaseRegTextChain
}