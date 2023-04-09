package com.alife.anotherlife.ui.screen.main.create_alife.mapper

import androidx.camera.core.ImageProxy
import com.alife.core.mapper.Mapper

class ImageProxyToByteArray : Mapper<ImageProxy, ByteArray> {

    override fun map(inputModel: ImageProxy): ByteArray {
        return inputModel.planes[0].buffer.run { ByteArray(remaining()) { get() } }
    }
}