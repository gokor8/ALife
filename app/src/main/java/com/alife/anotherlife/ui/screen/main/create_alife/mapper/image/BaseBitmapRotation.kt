package com.alife.anotherlife.ui.screen.main.create_alife.mapper.image

import android.graphics.Bitmap

interface BaseBitmapRotation {

    fun rotate(rotation: Float, bitmap: Bitmap): Bitmap
}