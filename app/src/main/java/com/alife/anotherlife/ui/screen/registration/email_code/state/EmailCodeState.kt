package com.alife.anotherlife.ui.screen.registration.email_code.state

import com.alife.anotherlife.core.composable.text.code.model.CodeModel
import com.alife.core.mvi.MVI

data class EmailCodeState(
    val codeModel: CodeModel = CodeModel.Init(),
) : MVI.State