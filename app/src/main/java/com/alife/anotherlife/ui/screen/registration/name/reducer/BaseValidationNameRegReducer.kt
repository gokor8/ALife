package com.alife.anotherlife.ui.screen.registration.name.reducer

import androidx.annotation.StringRes

interface BaseValidationNameRegReducer {

    fun onContinue()

    fun onValidationError(@StringRes errorResId: Int)
}