package com.alife.anotherlife.ui.screen.login.model.buttons.text

import androidx.annotation.StringRes
import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthModel


sealed class TextUIAuthModel(@StringRes protected val textRes: Int) : UIAuthModel