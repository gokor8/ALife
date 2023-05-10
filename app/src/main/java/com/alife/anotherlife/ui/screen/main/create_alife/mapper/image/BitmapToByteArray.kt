package com.alife.anotherlife.ui.screen.main.create_alife.mapper.image

import android.graphics.Bitmap
import java.io.ByteArrayOutputStream
import javax.inject.Inject

class BitmapToByteArray @Inject constructor() : BaseBitmapToByteArray {

    override fun map(inputModel: Bitmap): ByteArray {
        val stream = ByteArrayOutputStream()
        inputModel.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        val byteArray = stream.toByteArray()
        inputModel.recycle()

        return byteArray
    }
}