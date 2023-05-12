package com.alife.anotherlife.core.ui.dialog

import androidx.annotation.StringRes
import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.text.TextWrapper

class DefaultDialog(
    title: TextWrapper,
    description: TextWrapper,
    icon: Int = R.drawable.ic_base_error,
) : AbstractAlertDialog(icon, title, description) {

    constructor(
        @StringRes title: Int,
        @StringRes description: Int
    ) : this(TextWrapper.ResWrapper(title), TextWrapper.ResWrapper(description))
}