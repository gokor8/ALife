package com.alife.anotherlife.ui.screen.main.create_alife.mapper.image

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.nio.ByteBuffer
import javax.inject.Inject

class ImageProxyToBitmap @Inject constructor(): BaseImageProxyToBitmap {
    override fun map(inputModel: ByteBuffer): Bitmap {
        inputModel.rewind()
        val bytes = ByteArray(inputModel.capacity())
        inputModel.get(bytes)
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }
}