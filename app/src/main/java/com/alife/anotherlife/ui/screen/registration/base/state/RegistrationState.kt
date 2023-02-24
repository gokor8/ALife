package com.alife.anotherlife.ui.screen.registration.base.state

import com.alife.anotherlife.core.ui.state.error_text.TextWithErrorModel
import com.alife.anotherlife.ui.screen.registration.base.model.RegistrationModel
import com.alife.core.mvi.MVI

data class RegistrationState(
    val registrationModel: RegistrationModel,
    val textWithErrorModel: TextWithErrorModel = TextWithErrorModel(),
) : MVI.State