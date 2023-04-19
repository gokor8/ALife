package com.alife.anotherlife.ui.screen.registration.email_code

import com.alife.anotherlife.core.composable.text.code.CodeViewModel
import com.alife.anotherlife.core.composable.text.code.state.CodeAction
import com.alife.anotherlife.core.ui.view_model.AbstractViewModel
import com.alife.anotherlife.ui.screen.registration.email_code.reducer.BaseEmailCodeRegReducer
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeAction
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeEffect
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EmailCodeRegistrationVM @Inject constructor(
    override val reducerVM: BaseEmailCodeRegReducer
) : AbstractViewModel<EmailCodeAction, EmailCodeState, EmailCodeEffect>(),
    CodeViewModel {

    override val limit: Int = reducerVM.limit
    override val maskSymbol: Char = reducerVM.maskSymbol

    override fun map(inputModel: CodeAction) {
        reduce(EmailCodeAction.CodeBoxAction(inputModel))
    }

    override suspend fun onAction(action: EmailCodeAction) {
        action.onAction(reducerVM)
    }
}