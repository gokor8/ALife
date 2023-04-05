package com.alife.data.repository.main.create_alife.model.image

import com.alife.data.repository.main.create_alife.model.CreateAlifePathModel
import com.alife.data.repository.main.create_alife.model.base.BaseFileModel
import com.alife.data.repository.main.create_alife.model.base.BaseFileName
import java.io.FileOutputStream

class ImageFileModel(
    val imageByteArray: ByteArray,
    fileName: BaseFileName
) : BaseFileModel.Default(CreateAlifePathModel(), fileName, JpegExtension()) {
    override fun writeToFile(fileOutputStream: FileOutputStream) {
        imageByteArray.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream)
    }
}