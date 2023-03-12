package com.alife.anotherlife.di.ui.registration.name

import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.base.chain.EmptyTextChain
import com.alife.anotherlife.ui.screen.registration.base.chain.RegChainValidator
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.model.RegistrationModel
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.anotherlife.ui.screen.registration.name.chain.MaxNameTextChain
import com.alife.anotherlife.ui.screen.registration.name.chain.MinNameTextChain
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class NameRegViewModelModuleP {

    @NameAnnotation.NameUIStore
    @Reusable
    @Provides
    fun nameRegUIStore(): UIStore<RegistrationState, RegistrationEffect> =
        DefaultUIStore(
            RegistrationState(
                RegistrationModel(R.string.name, R.string.what_is_your_name)
            )
        )

    @NameAnnotation.NameChain
    @Provides
    fun regTextTextChain(
        maxNameTextChain: MaxNameTextChain,
        minNameTextChain: MinNameTextChain,
        emptyTextChain: EmptyTextChain,
    ) : BaseRegTextChain = RegChainValidator.StateValidator(
        emptyTextChain,
        RegChainValidator.StateValidator(
            maxNameTextChain,
            minNameTextChain
        )
    )
}