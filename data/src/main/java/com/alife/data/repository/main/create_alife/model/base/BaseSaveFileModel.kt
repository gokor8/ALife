package com.alife.data.repository.main.create_alife.model.base

import com.alife.data.repository.main.create_alife.model.base.file_builders.BaseFileExtension
import com.alife.data.repository.main.create_alife.model.base.file_builders.BaseFileName
import com.alife.data.repository.main.create_alife.model.base.file_builders.BasePathModel
import java.io.File
import java.io.FileOutputStream

interface BaseSaveFileModel : BaseFileModel {

    fun createFile(): File

    fun writeToFile(fileOutputStream: FileOutputStream)


    abstract class DefaultSave(
        filePath: BasePathModel,
        fileName: BaseFileName,
        fileExtension: BaseFileExtension
    ) : BaseFileModel.AbstractFileModel(filePath, fileName, fileExtension), BaseSaveFileModel {

        override fun createFile(): File {
            val myDir = File(filePath.getPath())
            if (myDir.exists()) myDir.mkdirs()

            val file = File(getFullFilePath())
            if (file.exists()) file.delete()

            return file
        }
    }
}