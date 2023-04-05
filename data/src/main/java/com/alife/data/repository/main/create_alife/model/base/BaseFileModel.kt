package com.alife.data.repository.main.create_alife.model.base

import java.io.File
import java.io.FileOutputStream

interface BaseFileModel {

    fun getFullFilePath(): String

    fun createFile(): File

    fun writeToFile(fileOutputStream: FileOutputStream)


    abstract class Default(
        private val filePath: BasePathModel,
        private val fileName: BaseFileName,
        private val fileExtension: BaseFileExtension
    ) : BaseFileModel {
        override fun getFullFilePath(): String = "$filePath$fileName$fileExtension"

        override fun createFile(): File {
            val myDir = File(filePath.getPath())
            if (myDir.exists()) myDir.mkdirs()

            val file = File(getFullFilePath())
            if (file.exists()) file.delete()

            return file
        }
    }
}