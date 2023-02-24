package com.alife.anotherlife.ui.screen.registration.base.state

import com.alife.anotherlife.core.ui.state.error_text.TextWithErrorModel
import com.alife.anotherlife.ui.screen.registration.base.model.RegistrationModel
import com.alife.core.mvi.MVI

data class RegistrationState(
    override val registrationModel: RegistrationModel,
    override val textWithErrorModel: TextWithErrorModel = TextWithErrorModel(),
) : BaseRegistrationState {

    override fun copyBase(registrationModel: RegistrationModel) =
        copy(registrationModel = registrationModel)

    override fun copyBase(textWithErrorModel: TextWithErrorModel) =
        copy(registrationModel = registrationModel)
}