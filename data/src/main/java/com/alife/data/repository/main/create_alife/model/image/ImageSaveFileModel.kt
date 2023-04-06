package com.alife.data.repository.main.create_alife.model.image

import com.alife.data.repository.main.create_alife.model.file.CreateAlifePathModel
import com.alife.data.repository.main.create_alife.model.base.BaseSaveFileModel
import com.alife.data.repository.main.create_alife.model.base.file_builders.BaseFileName
import java.io.FileOutputStream

class ImageSaveFileModel(
    private val imageByteArray: ByteArray,
    fileName: BaseFileName
) : BaseSaveFileModel.DefaultSave(CreateAlifePathModel(), fileName, JpegExtension()) {
    override fun writeToFile(fileOutputStream: FileOutputStream) {
        fileOutputStream.write(imageByteArray)
    }
}