package com.alife.data.repository.main.finish_create_alife.mapper

import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import javax.inject.Inject

interface BaseFileToMultipart {
    fun map(inputModel: File, fileType: FileMediaType): MultipartBody.Part
}

class FileToMultipart @Inject constructor(): BaseFileToMultipart{

    override fun map(inputModel: File, fileType: FileMediaType): MultipartBody.Part {
        return MultipartBody.Part.createFormData(
            inputModel.nameWithoutExtension,
            inputModel.name,
            RequestBody.create(
                MediaType.parse(fileType.mediaType()),
                inputModel
            )
        )
    }
}