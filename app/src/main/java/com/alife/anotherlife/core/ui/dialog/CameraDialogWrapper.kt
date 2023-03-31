package com.alife.anotherlife.core.ui.dialog

import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.text.TextWrapper

class CameraDialogWrapper : AbstractDialogWrapper(
    R.drawable.ic_dialog_camera,
    TextWrapper.ResWrapper(R.string.dialog_camera_title),
    TextWrapper.ResWrapper(R.string.dialog_camera_description)
)