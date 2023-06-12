package com.alife.data.repository.main.create_alife.picture.model.image

import com.alife.data.data_source.cache.file.base.FileWrapperFactory
import com.alife.data.core.file_model_base.CreateAlifePathModel
import com.alife.data.core.file_model_base.BaseSaveFileModel
import com.alife.data.core.file_model_base.file_builders.BaseFileName
import java.io.FileOutputStream

class ImageSave(
    private val imageByteArray: ByteArray,
    createAlifePathModel: CreateAlifePathModel,
    fileName: BaseFileName,
    fileWrapperFactory: FileWrapperFactory
) : BaseSaveFileModel.DefaultSave(
    createAlifePathModel,
    fileName,
    JpegExtension(),
    fileWrapperFactory
) {
    override fun writeToFile(fileOutputStream: FileOutputStream) {
        fileOutputStream.write(imageByteArray)
    }
}