package com.alife.anotherlife.core.ui.dialog

import androidx.annotation.StringRes
import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.text.TextWrapper
import javax.inject.Inject

abstract class SettingsDialog(@StringRes title: Int) : AbstractDialog(
    R.drawable.ic_base_error,
    TextWrapper.ResWrapper(title),
    TextWrapper.ResWrapper(R.string.permission_dialog_description),
    DialogButtonStrategy.OneButton(R.string.permission_dialog_settings)
) {

    class Camera @Inject constructor() : SettingsDialog(R.string.dialog_camera_title)
    class Audio @Inject constructor() : SettingsDialog(R.string.dialog_audio_title)
}