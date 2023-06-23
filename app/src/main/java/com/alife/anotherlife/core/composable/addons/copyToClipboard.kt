package com.alife.anotherlife.core.composable.addons

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import com.alife.anotherlife.R

fun copyToClipboard(context: Context, text: String, toast: String) {
    val clipboardManager =
        context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText(toast, text)
    clipboardManager.setPrimaryClip(clip)

    Toast.makeText(context, toast, Toast.LENGTH_SHORT).show()
}