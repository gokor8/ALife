package com.alife.anotherlife.di.ui.registration.birthday

import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.base.chain.EmptyTextChain
import com.alife.anotherlife.ui.screen.registration.base.chain.RegTextTextChain
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.model.RegistrationModel
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.anotherlife.ui.screen.registration.birthday.BirthdayRegistrationVM
import com.alife.anotherlife.ui.screen.registration.birthday.chain.BirthdayChainValidator
import com.alife.anotherlife.ui.screen.registration.birthday.chain.BirthdayDateTextChain
import com.alife.anotherlife.ui.screen.registration.birthday.chain.BirthdayTextChain
import com.alife.anotherlife.ui.screen.registration.birthday.chain.BirthdayYearLimit
import com.alife.core.chain.ChainHandler
import com.alife.domain.core.chain.ChainEmptyValidator
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import java.util.Locale

@Module
@InstallIn(ViewModelComponent::class)
class BirthdayRegViewModelModuleP {

    @BirthdayAnnotation.BirthdayUIStore
    @Reusable
    @Provides
    fun birthdayUIStore(): UIStore<RegistrationState, RegistrationEffect> =
        DefaultUIStore(
            RegistrationState(
                RegistrationModel(R.string.birthday, R.string.i_need_your_birthday)
            )
        )

    @BirthdayAnnotation.BirthdayChain
    @Provides
    fun birthdayChain(
        emptyTextChain: EmptyTextChain,
        birthdayDateTextChain: BirthdayDateTextChain,
    ): BaseRegTextChain {
        return RegTextTextChain(
            emptyTextChain,
            BirthdayChainValidator(
                birthdayDateTextChain,
                BirthdayYearLimit()
            )
        )
    }
}