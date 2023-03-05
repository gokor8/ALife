package com.alife.anotherlife.di.ui.registration.email_code

import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.registration.email.EmailAnnotation
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeEffect
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeState
import dagger.Provides
import dagger.Reusable
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class EmailCodeRegViewModelP {

    @Reusable
    @Provides
    fun emailCodeUIStore(): UIStore<EmailCodeState, EmailCodeEffect> {
        return DefaultUIStore(EmailCodeState())
    }
}