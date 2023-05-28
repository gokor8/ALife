package com.alife.anotherlife.ui.activity.mapper

import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.ui.activity.model.ActivityLCEErrorContract
import com.alife.anotherlife.ui.activity.model.LCEGlobalError
import com.alife.anotherlife.ui.activity.model.LCETimeoutError
import java.net.SocketTimeoutException
import javax.inject.Inject

interface BaseCloudExceptionToActivityState {
    fun map(contract: ActivityLCEErrorContract, exception: Throwable): LCEModel.Error
}

class CloudExceptionToActivityState @Inject constructor() : BaseCloudExceptionToActivityState {

    override fun map(
        contract: ActivityLCEErrorContract,
        exception: Throwable
    ): LCEModel.Error {
        return when(exception) {
            // TODO может на эту ошибку выводить что то типо сервер не доступен
            is SocketTimeoutException -> LCETimeoutError(contract)
            else -> LCEGlobalError(contract)
        }
    }
}