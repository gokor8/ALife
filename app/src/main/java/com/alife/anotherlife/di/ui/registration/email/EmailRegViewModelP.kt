package com.alife.anotherlife.di.ui.registration.email

import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.registration.birthday.BirthdayAnnotation
import com.alife.anotherlife.ui.screen.registration.base.chain.EmptyTextChain
import com.alife.anotherlife.ui.screen.registration.base.chain.RegChainValidator
import com.alife.anotherlife.ui.screen.registration.base.chain.RegTextTextChain
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.model.RegistrationModel
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.anotherlife.ui.screen.registration.birthday.chain.BirthdayChainValidator
import com.alife.anotherlife.ui.screen.registration.birthday.chain.BirthdayDateTextChain
import com.alife.anotherlife.ui.screen.registration.birthday.chain.BirthdayYearGafferLimit
import com.alife.anotherlife.ui.screen.registration.birthday.chain.BirthdayYoungLimit
import com.alife.anotherlife.ui.screen.registration.email.chain.EmailRegTextChain
import com.alife.core.chain.ChainValidator
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class EmailRegViewModelP {

    @EmailAnnotation.EmailUIStore
    @Reusable
    @Provides
    fun emailUIStore(): UIStore<RegistrationState, RegistrationEffect> =
        DefaultUIStore(
            RegistrationState(
                RegistrationModel(R.string.email, R.string.your_email)
            )
        )

    @EmailAnnotation.EmailChain
    @Provides
    fun emailChain(
        emptyTextChain: EmptyTextChain,
        emailRegTextChain: EmailRegTextChain
    ): BaseRegTextChain {
        return RegChainValidator(
            emptyTextChain,
            emailRegTextChain
        )
    }
}