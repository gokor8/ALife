package com.alife.anotherlife.ui.screen.main.create_alife.mapper

import androidx.camera.core.ImageProxy
import com.alife.core.mapper.Mapper
import javax.inject.Inject

class ImageProxySelectMapper @Inject constructor() : Mapper<ImageProxy, ByteArray> {

    override fun map(inputModel: ImageProxy): ByteArray {
        return if (inputModel.planes.size > 1)
            ImageProxyToYuvByteArray().map(inputModel)
        else
            ImageProxyToByteArray().map(inputModel)
    }
}