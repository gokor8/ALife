package com.alife.anotherlife.ui.screen.registration.email_code.reducer

import com.alife.anotherlife.core.composable.text.code.model.CodeModel
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeEffect
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeState
import javax.inject.Inject

class EmailCodeRegReducerBase @Inject constructor(
    override val uiStore: UIStore<EmailCodeState, EmailCodeEffect>
) : AbstractEmailCodeRegReducerBase(6, '•') {

    override suspend fun onCode(code: String) {
        val currentCode = uiStore.getState().codeModel.copy(code)

        if (currentCode is CodeModel.Filling && currentCode.isFill(limit)) {
            uiStore.setState { copy(codeModel = CodeModel.Filled(code)) }
            uiStore.setEffect(EmailCodeEffect.NavigateTutorial())
        } else {
            uiStore.setState { copy(codeModel = currentCode) }
        }
    }
}