package com.alife.anotherlife.ui.activity

import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.activity.mapper.BaseCloudExceptionToActivityState
import com.alife.anotherlife.ui.activity.model.ActivityLCEErrorContract
import com.alife.anotherlife.ui.activity.model.LCEGlobalError
import com.alife.anotherlife.ui.activity.state.MainActivityEffect
import com.alife.anotherlife.ui.activity.state.MainActivityState
import com.alife.core.mapper.Mapper
import com.alife.domain.core.exception_global.CloudExceptionHandler
import com.alife.domain.core.exception_global.CommonExceptionHandler
import com.alife.domain.core.exception_global.GlobalException
import com.alife.domain.core.exception_global.GlobalExceptionHandler
import com.alife.domain.core.exception_global.GoToLoginException
import java.lang.Exception
import javax.inject.Inject

class MainActivityReducer @Inject constructor(
    override val uiStore: UIStore<MainActivityState, MainActivityEffect>,
    private val exceptionMapper: BaseCloudExceptionToActivityState,
) : AbstractVMReducer<MainActivityState, MainActivityEffect>(), BaseMainActivityReducer,
    CommonExceptionHandler, ActivityLCEErrorContract {

    override fun handle(exception: GlobalException) {
        if (exception is GoToLoginException)
            trySetEffect(MainActivityEffect.GoToLogin())
        else
            setState { copy(lceModel = LCEGlobalError(this@MainActivityReducer)) }

        // TODO add ServerUnavailable handling
    }

    override fun handle(exception: Throwable) {
        setState {
            copy(lceModel = exceptionMapper.map(this@MainActivityReducer, exception))
        }
    }

    override fun showContent() {
        setState { copy(lceModel = LCEContent) }
    }
}