package com.alife.anotherlife.ui.screen.registration.base.state

import com.alife.anotherlife.core.ui.state.error_text.TextErrorModel
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.state.lce.StateLCE
import com.alife.anotherlife.ui.screen.registration.base.model.RegistrationModel
import com.alife.core.mvi.MVI

data class RegistrationState(
    val registrationModel: RegistrationModel,
    override val lceModel: LCEModel = LCEContent,
    val textErrorModel: TextErrorModel = TextErrorModel(),
) : StateLCE