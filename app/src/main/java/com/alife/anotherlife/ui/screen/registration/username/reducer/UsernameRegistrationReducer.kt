package com.alife.anotherlife.ui.screen.registration.username.reducer

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.registration.name.NameAnnotation
import com.alife.anotherlife.di.ui.registration.username.UsernameAnnotation
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseRegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.anotherlife.ui.screen.registration.username.chain.UsernameRegTextChain
import com.alife.domain.registration.core.entity.DefaultRegEntity
import com.alife.domain.registration.usecase.name.BaseNameUseCase
import com.alife.domain.registration.usecase.username.BaseUsernameUseCase
import com.alife.domain.registration.usecase.username.addons.UsernameRegEntity
import javax.inject.Inject

class UsernameRegistrationReducer @Inject constructor(
    @UsernameAnnotation.UsernameUIStore
    uiStore: UIStore<RegistrationState, RegistrationEffect>,
    @NameAnnotation.NameChain
    nameChainValidator: BaseRegTextChain,
    @UsernameAnnotation.UsernameValidation
    validationNameRegReducer: BaseValidationRegReducer,
    usernameRegTextChain: UsernameRegTextChain,
    readUsernameUseCase: BaseUsernameUseCase.Read,
) : BaseRegistrationReducer.WithInputChain<UsernameRegEntity>(
    uiStore,
    nameChainValidator,
    validationNameRegReducer,
    readUsernameUseCase,
    usernameRegTextChain,
) {

    override suspend fun onBackPress() {
        uiStore.setEffect(RegistrationEffect.NavigateName())
    }
}