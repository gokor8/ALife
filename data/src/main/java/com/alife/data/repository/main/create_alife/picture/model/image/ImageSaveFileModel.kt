package com.alife.data.repository.main.create_alife.picture.model.image

import com.alife.data.data_source.cache.file.base.FileWrapperFactory
import com.alife.data.repository.main.create_alife.picture.model.file.CreateAlifePathModel
import com.alife.data.repository.main.create_alife.file_model_base.BaseSaveFileModel
import com.alife.data.repository.main.create_alife.file_model_base.file_builders.BaseFileName
import java.io.FileOutputStream

class ImageSaveFileModel(
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