package com.alife.data.repository.main.create_alife.model.base

import com.alife.data.data_source.cache.file.base.FileWrapperFactory
import com.alife.data.repository.main.create_alife.model.base.file_builders.BaseFileExtension
import com.alife.data.repository.main.create_alife.model.base.file_builders.BaseFileName
import com.alife.data.repository.main.create_alife.model.base.file_builders.BasePathModel
import java.io.BufferedInputStream
import java.io.File
import java.io.FileNotFoundException

interface BaseReadFileModel : BaseFileModel {

    fun readFromFile(
        buffer: BufferedInputStream,
        fileWrapperFactory: FileWrapperFactory
    ): ByteArray


    abstract class DefaultRead(
        filePath: BasePathModel,
        fileName: BaseFileName,
        fileExtension: BaseFileExtension,
    ) : BaseFileModel.AbstractFileModel(filePath, fileName, fileExtension), BaseReadFileModel {

        override fun readFromFile(
            buffer: BufferedInputStream,
            fileWrapperFactory: FileWrapperFactory
        ): ByteArray {
            val file = fileWrapperFactory.create(getFullFilePath())

            // TODO проверить, может быть файл сам ошибку выкинет
            if(!file.exists()) throw FileNotFoundException()

            val imageByteArray = ByteArray(file.length())

            buffer.read(imageByteArray, 0, imageByteArray.size)

            return imageByteArray
        }
    }
}