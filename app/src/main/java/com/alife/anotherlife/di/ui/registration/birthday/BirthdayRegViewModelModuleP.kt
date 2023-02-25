package com.alife.anotherlife.di.ui.registration.birthday

import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.base.model.RegistrationModel
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.anotherlife.ui.screen.registration.birthday.BirthdayRegistrationVM
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

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
}