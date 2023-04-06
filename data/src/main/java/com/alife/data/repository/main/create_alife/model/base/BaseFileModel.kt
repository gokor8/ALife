package com.alife.data.repository.main.create_alife.model.base

import com.alife.data.repository.main.create_alife.model.base.file_builders.BaseFileExtension
import com.alife.data.repository.main.create_alife.model.base.file_builders.BaseFileName
import com.alife.data.repository.main.create_alife.model.base.file_builders.BasePathModel

interface BaseFileModel {

    fun getFullFilePath(): String


    abstract class AbstractFileModel(
        protected val filePath: BasePathModel,
        protected val fileName: BaseFileName,
        protected val fileExtension: BaseFileExtension
    ) : BaseFileModel {
        override fun getFullFilePath(): String {
            return "${filePath.getPath()}${fileName.getFileName()}${fileExtension.getFileExtension()}"
        }
    }
}