package com.alife.anotherlife.core.ui.dialog.location

import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.dialog.AbstractDialog
import com.alife.anotherlife.core.ui.dialog.DialogButtonStrategy
import com.alife.anotherlife.core.ui.text.TextWrapper

class FatalLocationDialog : AbstractDialog(
    R.drawable.ic_dialog_camera,
    TextWrapper.ResWrapper(R.string.dialog_location_title),
    TextWrapper.ResWrapper(R.string.dialog_location_description),
    DialogButtonStrategy.OneButton(R.string.permission_dialog_settings)
)