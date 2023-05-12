package com.alife.anotherlife.core.ui.dialog

import androidx.annotation.StringRes
import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.text.TextWrapper

class DefaultDialog(
    title: TextWrapper,
    description: TextWrapper,
    dialogButtonStrategy: DialogButtonStrategy,
    icon: Int = R.drawable.ic_base_error,
) : AbstractDialog(icon, title, description, dialogButtonStrategy) {

    constructor(
        @StringRes title: Int,
        @StringRes description: Int,
        dialogButtonStrategy: DialogButtonStrategy
    ) : this(
        TextWrapper.ResWrapper(title),
        TextWrapper.ResWrapper(description),
        dialogButtonStrategy
    )
}