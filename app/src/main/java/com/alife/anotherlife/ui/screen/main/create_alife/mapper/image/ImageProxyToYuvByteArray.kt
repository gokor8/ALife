package com.alife.anotherlife.ui.screen.main.create_alife.mapper.image

import android.graphics.ImageFormat
import android.graphics.Rect
import android.graphics.YuvImage
import androidx.camera.core.ImageProxy
import com.alife.core.mapper.Mapper
import java.io.ByteArrayOutputStream

class ImageProxyToYuvByteArray : Mapper<ImageProxy, ByteArray> {

    override fun map(inputModel: ImageProxy): ByteArray {
        val yBuffer = inputModel.planes[0].buffer
        val vuBuffer = inputModel.planes[2].buffer

        val ySize = yBuffer.remaining()
        val vuSize = vuBuffer.remaining()

        val nv21 = ByteArray(ySize + vuSize)

        yBuffer.get(nv21, 0, ySize)
        vuBuffer.get(nv21, ySize, vuSize)

        val yuvImage = YuvImage(nv21, ImageFormat.NV21, inputModel.width, inputModel.height, null)
        val out = ByteArrayOutputStream()
        yuvImage.compressToJpeg(Rect(0, 0, yuvImage.width, yuvImage.height), 50, out)

        return out.toByteArray()
    }
}