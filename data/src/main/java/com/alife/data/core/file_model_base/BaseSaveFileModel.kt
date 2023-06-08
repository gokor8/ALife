package com.alife.data.core.file_model_base

import com.alife.data.data_source.cache.file.base.FileWrapperFactory
import com.alife.data.core.file_model_base.file_builders.BaseFileExtension
import com.alife.data.core.file_model_base.file_builders.BaseFileName
import com.alife.data.core.file_model_base.file_builders.BasePathModel
import java.io.File
import java.io.FileOutputStream

interface BaseSaveFileModel : BaseFileModel {

    fun writeToFile(fileOutputStream: FileOutputStream)


    abstract class DefaultSave(
        filePath: BasePathModel,
        fileName: BaseFileName,
        fileExtension: BaseFileExtension,
        private val fileWrapperFactory: FileWrapperFactory
    ) : BaseFileModel.AbstractFileModel(filePath, fileName, fileExtension), BaseSaveFileModel {

        override fun createFile(): File {
            val myDir = fileWrapperFactory.create(getFullPath())
            if (!myDir.exists()) myDir.mkdirs()

            val fileWrapper = fileWrapperFactory.create(getFullPath())
            if (fileWrapper.exists()) fileWrapper.delete()

            return fileWrapper.file
        }
    }
}