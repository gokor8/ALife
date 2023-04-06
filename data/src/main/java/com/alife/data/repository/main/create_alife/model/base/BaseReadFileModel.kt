package com.alife.data.repository.main.create_alife.model.base

import com.alife.data.repository.main.create_alife.model.base.file_builders.BaseFileExtension
import com.alife.data.repository.main.create_alife.model.base.file_builders.BaseFileName
import com.alife.data.repository.main.create_alife.model.base.file_builders.BasePathModel
import java.io.BufferedInputStream
import java.io.File

interface BaseReadFileModel : BaseFileModel {

    fun readFromFile(buffer: BufferedInputStream): ByteArray


    abstract class DefaultRead(
        filePath: BasePathModel,
        fileName: BaseFileName,
        fileExtension: BaseFileExtension
    ) : BaseFileModel.AbstractFileModel(filePath, fileName, fileExtension), BaseReadFileModel {

        override fun readFromFile(buffer: BufferedInputStream): ByteArray {
            val file = File(getFullFilePath())
            val imageByteArray = ByteArray(file.length().toInt())

            buffer.read(imageByteArray, 0, imageByteArray.size)

            return imageByteArray
        }
    }
}