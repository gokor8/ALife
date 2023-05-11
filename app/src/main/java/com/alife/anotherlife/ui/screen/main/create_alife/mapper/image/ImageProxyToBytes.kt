package com.alife.anotherlife.ui.screen.main.create_alife.mapper.image

import java.nio.ByteBuffer
import javax.inject.Inject

interface BaseImageProxyToBytes {
    fun map(imageBuffer: ByteBuffer, rotationDegrees: Float): ByteArray
}

class ImageProxyToBytes @Inject constructor(
    private val imageProxyToBitmap: BaseImageProxyToBitmap,
    private val bitmapRotation: BaseBitmapRotation,
    private val bitmapToByteArray: BaseBitmapToByteArray
) : BaseImageProxyToBytes {

    override fun map(imageBuffer: ByteBuffer, rotationDegrees: Float): ByteArray {
        val bitmap = imageProxyToBitmap.map(imageBuffer)

        val rotatedBitmap = bitmapRotation.rotate(rotationDegrees, bitmap)

        return bitmapToByteArray.map(rotatedBitmap)
    }
}