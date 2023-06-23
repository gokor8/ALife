package com.alife.anotherlife.ui.screen.main.create_alife.mapper.image

import android.graphics.Bitmap
import android.graphics.Matrix
import javax.inject.Inject

class BitmapRotation @Inject constructor() : BaseBitmapRotation {

    override fun rotate(rotation: Float, bitmap: Bitmap): Bitmap {
        val matrix = Matrix().apply { postRotate(rotation) }
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
    }
}