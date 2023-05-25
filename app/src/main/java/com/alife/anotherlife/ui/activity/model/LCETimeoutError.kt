package com.alife.anotherlife.ui.activity.model

import com.alife.anotherlife.R

class LCETimeoutError(contract: ActivityLCEErrorContract) : AbstractActivityLCEError(
    R.string.connection_exception,
    R.string.try_again,
    R.string.repeat,
    contract
)