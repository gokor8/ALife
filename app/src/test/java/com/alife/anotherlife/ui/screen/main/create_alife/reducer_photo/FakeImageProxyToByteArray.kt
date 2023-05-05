package com.alife.anotherlife.ui.screen.main.create_alife.reducer_photo

import androidx.camera.core.ImageProxy
import com.alife.core.mapper.Mapper

class FakeImageProxyToByteArray : Mapper<ImageProxy, ByteArray> {

    override fun map(inputModel: ImageProxy) = ByteArray(0)
}