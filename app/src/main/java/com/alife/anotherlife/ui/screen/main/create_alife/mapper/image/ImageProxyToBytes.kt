package com.alife.anotherlife.ui.screen.main.create_alife.mapper.image

import androidx.camera.core.ImageProxy
import com.alife.core.mapper.Mapper
import javax.inject.Inject

interface BaseImageProxyToBytes : Mapper<ImageProxy, ByteArray>

class ImageProxyToBytes @Inject constructor(
    private val imageProxyToBitmap: BaseImageProxyToBitmap,
    private val bitmapRotation: BaseBitmapRotation,
    private val bitmapToByteArray: BaseBitmapToByteArray
) : BaseImageProxyToBytes {

    override fun map(inputModel: ImageProxy): ByteArray {
        val bitmap = imageProxyToBitmap.map(inputModel.planes[0].buffer)

        val rotatedBitmap = bitmapRotation.rotate(
            inputModel.imageInfo.rotationDegrees.toFloat(),
            bitmap
        )

        return bitmapToByteArray.map(rotatedBitmap)
    }
}