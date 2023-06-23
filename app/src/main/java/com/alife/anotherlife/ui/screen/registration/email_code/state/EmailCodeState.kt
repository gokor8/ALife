package com.alife.anotherlife.ui.screen.registration.email_code.state

import com.alife.anotherlife.core.composable.text.code.model.CodeModel
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.state.lce.StateLCE
import com.alife.anotherlife.core.ui.text.TextWrapper

data class EmailCodeState(
    override val lceModel: LCEModel = LCEContent,
    val codeModel: CodeModel = CodeModel.Init(),
    val error: TextWrapper = TextWrapper.StringWrapper(),
) : StateLCE