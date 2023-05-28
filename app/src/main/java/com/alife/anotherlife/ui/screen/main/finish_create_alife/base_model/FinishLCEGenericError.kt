package com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model

import com.alife.anotherlife.R
import com.alife.anotherlife.ui.activity.model.LCEGenericError

class FinishLCEGenericError(errorContract: FinishErrorContract) :
    LCEGenericError(R.string.repeat, { errorContract.onRetryEffect() })