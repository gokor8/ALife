package com.alife.anotherlife.ui.activity.model

import com.alife.anotherlife.R

class LCEGlobalError(contract: ActivityLCEErrorContract) : AbstractActivityLCEError(
    R.string.global_exception,
    R.string.try_later,
    R.string.repeat,
    contract
)