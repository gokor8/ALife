package com.alife.anotherlife.ui.activity

import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.activity.model.LCEGlobalError
import com.alife.anotherlife.ui.activity.state.MainActivityEffect
import com.alife.anotherlife.ui.activity.state.MainActivityState
import com.alife.domain.core.exception_global.GlobalException
import com.alife.domain.core.exception_global.GlobalExceptionHandler
import com.alife.domain.core.exception_global.GoToLoginException
import javax.inject.Inject

class MainActivityReducer @Inject constructor(
    override val uiStore: UIStore<MainActivityState, MainActivityEffect>
) : AbstractVMReducer<MainActivityState, MainActivityEffect>(), BaseMainActivityReducer,
    GlobalExceptionHandler {

    override fun handle(exception: GlobalException) {
        if (exception is GoToLoginException)
            trySetEffect(MainActivityEffect.GoToLogin())
        else
            setState { copy(lceModel = LCEGlobalError()) }

        // TODO add ServerUnavailable handling
    }
}