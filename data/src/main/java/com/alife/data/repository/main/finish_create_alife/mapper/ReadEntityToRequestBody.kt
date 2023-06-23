package com.alife.data.repository.main.finish_create_alife.mapper

import com.alife.domain.main.create_alife.entity.CreateAlifeReadEntity
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

interface BaseReadEntityToRequestBody {

    fun map(inputModel: CreateAlifeReadEntity, fileType: FileMediaType): MultipartBody.Part
}

class ReadEntityToRequestBody @Inject constructor(
    private val readEntityToFile: BaseReadEntityToFile,
    private val fileToMultipart: BaseFileToMultipart
) : BaseReadEntityToRequestBody {

    override fun map(
        inputModel: CreateAlifeReadEntity,
        fileType: FileMediaType
    ): MultipartBody.Part {
        val file = readEntityToFile.map(inputModel)

        return fileToMultipart.map(file, fileType)
    }
}