package com.alife.anotherlife.di.ui.registration.username

import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.base.chain.AccessSymbolsChain
import com.alife.anotherlife.ui.screen.registration.base.model.RegistrationModel
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.anotherlife.ui.screen.registration.name.chain.FirstIsLetterTextChain
import com.alife.anotherlife.ui.screen.registration.username.chain.AccessCharsUsernameTextChain
import com.alife.anotherlife.ui.screen.registration.username.chain.UsernameMaxTextChain
import com.alife.anotherlife.ui.screen.registration.username.chain.UsernameRegTextChain
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UsernameRegViewModelModuleP {

    @UsernameAnnotation.UsernameUIStore
    @Reusable
    @Provides
    fun nameRegUIStore(): UIStore<RegistrationState, RegistrationEffect> =
        DefaultUIStore(
            RegistrationState(
                RegistrationModel(R.string.username, R.string.also_need_your_username)
            )
        )

    @UsernameAnnotation.UsernameAccessSymbolArray
    @Provides
    fun accessSymbolArray(): CharArray = charArrayOf('_', '-', '.')

    @Provides
    fun usernameRegTextChain(
        @UsernameAnnotation.UsernameAccessSymbolArray
        accessSymbolArray: CharArray,
        firstIsLetterTextChain: FirstIsLetterTextChain,
    ): UsernameRegTextChain = AccessCharsUsernameTextChain(
        AccessSymbolsChain(accessSymbolArray),
        UsernameMaxTextChain(),
        firstIsLetterTextChain
    )
}