package com.alife.anotherlife.ui.screen.registration.email_code.reducer

import com.alife.anotherlife.core.composable.text.code.model.CodeModel
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.core.ui.text.TextWrapper
import com.alife.anotherlife.ui.screen.registration.email_code.mapper.BaseCodeExceptionMapper
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeEffect
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeState
import com.alife.domain.registration.usecase.email_code.BaseEmailCodeUseCase
import javax.inject.Inject

class EmailCodeRegReducerBase @Inject constructor(
    override val uiStore: UIStore<EmailCodeState, EmailCodeEffect>,
    private val emailCodeUseCase: BaseEmailCodeUseCase,
    private val mapper: BaseCodeExceptionMapper
) : AbstractEmailCodeRegReducerBase(6, '•') {

    override suspend fun onCode(code: String) {
        setState { copy(error = TextWrapper.StringWrapper()) }

        val currentCode = uiStore.getState().codeModel.copy(code)

        if (currentCode is CodeModel.Filling && currentCode.isFill(limit)) {
            executeThis(getState()) { exception ->
                setState(mapper.map(exception, this@EmailCodeRegReducerBase))
            }.handle {
                emailCodeUseCase.sendCode(code)
                uiStore.setEffect(EmailCodeEffect.NavigateTutorial())
            }
        } else {
            uiStore.setState { copy(codeModel = currentCode) }
        }
    }
}