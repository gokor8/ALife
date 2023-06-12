package com.alife.data.core.file_model_base

import com.alife.data.core.file_model_base.file_builders.BaseFileExtension
import com.alife.data.core.file_model_base.file_builders.BaseFileName
import com.alife.data.core.file_model_base.file_builders.BasePathModel
import java.io.File

interface BaseFileModel {

    fun getFullPath(): String

    fun createFile(): File = File(getFullPath())


    abstract class Abstract(
        protected val filePath: BasePathModel,
        protected val fileName: BaseFileName,
        protected val fileExtension: BaseFileExtension
    ) : BaseFileModel {
        override fun getFullPath(): String {
            return "${filePath.getPath()}/${fileName.getFileName()}${fileExtension.getFileExtension()}"
        }
    }
}