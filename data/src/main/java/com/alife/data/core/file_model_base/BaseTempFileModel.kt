package com.alife.data.core.file_model_base

import com.alife.data.core.file_model_base.file_builders.BaseFileExtension
import com.alife.data.core.file_model_base.file_builders.BaseFileName
import java.io.File

interface BaseTempFileModel : BaseFileName, BaseFileExtension {

    fun createTempFile(): File

    class Default(
        private val fileName: BaseFileName,
        private val fileExtension: BaseFileExtension
    ) : BaseTempFileModel {

        override fun createTempFile(): File {
            return File(getFileName(), ".${getFileExtension()}")
        }

        override fun getFileName(): String = fileName.getFileName()

        override fun getFileExtension(): String = fileExtension.getFileExtension()
    }
}