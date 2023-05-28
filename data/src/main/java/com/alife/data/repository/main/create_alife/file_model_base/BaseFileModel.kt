package com.alife.data.repository.main.create_alife.file_model_base

import com.alife.data.repository.main.create_alife.file_model_base.file_builders.BaseFileExtension
import com.alife.data.repository.main.create_alife.file_model_base.file_builders.BaseFileName
import com.alife.data.repository.main.create_alife.file_model_base.file_builders.BasePathModel

interface BaseFileModel {

    fun getFullPath(): String


    abstract class AbstractFileModel(
        protected val filePath: BasePathModel,
        protected val fileName: BaseFileName,
        protected val fileExtension: BaseFileExtension
    ) : BaseFileModel {
        override fun getFullPath(): String {
            return "${filePath.getPath()}/${fileName.getFileName()}${fileExtension.getFileExtension()}"
        }
    }
}