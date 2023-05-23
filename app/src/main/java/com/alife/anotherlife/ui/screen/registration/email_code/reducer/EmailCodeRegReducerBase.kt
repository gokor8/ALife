package com.alife.anotherlife.ui.screen.registration.email_code.reducer

import com.alife.anotherlife.core.composable.text.code.model.CodeModel
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeEffect
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeState
import com.alife.domain.registration.usecase.email_code.BaseEmailCodeUseCase
import javax.inject.Inject

class EmailCodeRegReducerBase @Inject constructor(
    override val uiStore: UIStore<EmailCodeState, EmailCodeEffect>,
    private val emailCodeUseCase: BaseEmailCodeUseCase,
    private val codeExceptionMapper:
) : AbstractEmailCodeRegReducerBase(6, '•') {

    override suspend fun onCode(code: String) {
        val currentCode = uiStore.getState().codeModel.copy(code)

        if (currentCode is CodeModel.Filling && currentCode.isFill(limit)) {
            uiStore.setState { copy(codeModel = CodeModel.Filled(code)) }

            // TODO fix it
            execute {
                /* TODO set error */
            }.handle {
                emailCodeUseCase.sendCode(code)
                // TODO save tokens
                uiStore.setEffect(EmailCodeEffect.NavigateTutorial())
            }
        } else {
            uiStore.setState { copy(codeModel = currentCode) }
        }
    }
}