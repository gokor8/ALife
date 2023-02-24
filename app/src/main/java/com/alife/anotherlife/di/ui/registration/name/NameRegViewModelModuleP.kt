package com.alife.anotherlife.di.ui.registration.name

import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class NameRegViewModelModuleP {

    @Provides
    fun nameRegUIStore(): UIStore<RegistrationState, RegistrationEffect> = DefaultUIStore(RegistrationState())
}