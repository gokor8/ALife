package com.alife.anotherlife.core.ui.dialog.audio

import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.dialog.AbstractDialog
import com.alife.anotherlife.core.ui.text.TextWrapper
import javax.inject.Inject

class AudioDialog @Inject constructor(): AbstractDialog(
    R.drawable.ic_dialog_micro,
    TextWrapper.ResWrapper(R.string.dialog_audio_title),
    TextWrapper.ResWrapper(R.string.dialog_audio_description)
)