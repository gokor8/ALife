package com.alife.anotherlife.ui.screen.registration.reg_test.model

import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer

class FakeChainNamRegReducer : BaseValidationRegReducer {

    var resultContainer: Int = 0

    override fun onContinue() {
        resultContainer = 0
    }

    override fun onValidationError(errorResId: Int) {
        resultContainer = errorResId
    }
}