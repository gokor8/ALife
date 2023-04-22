package com.alife.anotherlife.core.ui.dialog.camera

import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.dialog.AbstractDialog
import com.alife.anotherlife.core.ui.text.TextWrapper
import javax.inject.Inject

class CameraDialog @Inject constructor(): AbstractDialog(
    R.drawable.ic_dialog_camera,
    TextWrapper.ResWrapper(R.string.dialog_camera_title),
    TextWrapper.ResWrapper(R.string.dialog_camera_description)
)