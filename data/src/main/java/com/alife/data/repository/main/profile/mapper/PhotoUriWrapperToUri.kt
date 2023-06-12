package com.alife.data.repository.main.profile.mapper

import android.content.Context
import android.net.Uri
import com.alife.core.mapper.Mapper
import com.alife.data.core.file_model_base.CreateAlifePathModel
import com.alife.data.core.file_model_base.Temp
import com.alife.data.core.file_model_base.file_builders.BaseFileExtension
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import javax.inject.Inject

interface BaseUriToTempFile : Mapper<Uri, File>

class UriToTempFile @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val uriToFileName: BaseUriToFileName,
    private val fileNameToSeparate: BaseFileNameToSeparate
) : BaseUriToTempFile {

    private val defaultBufferSize = 4 * 1024

    override fun map(inputModel: Uri): File {
        val fileModel = fileNameToSeparate.map(uriToFileName.map(inputModel))


        val file = Temp(
            CreateAlifePathModel(context),
            BaseFileExtension.Default(fileModel.second)
        ).createFile()

        context.contentResolver.openInputStream(inputModel)?.use { inputStream ->
            val output = FileOutputStream(file)

            val buffer = ByteArray(defaultBufferSize)

            var read: Int
            while (inputStream.read(buffer).also { read = it } != -1) {
                output.write(buffer, 0, read)
            }

            output.flush()
        } ?: throw IOException()

        return file
    }
}