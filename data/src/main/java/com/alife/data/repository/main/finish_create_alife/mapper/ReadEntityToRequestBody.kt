package com.alife.data.repository.main.finish_create_alife.mapper

import com.alife.domain.main.create_alife.entity.CreateAlifeReadEntity
import okhttp3.MediaType
import okhttp3.RequestBody
import javax.inject.Inject

interface BaseReadEntityToRequestBody {

    fun map(inputModel: CreateAlifeReadEntity, fileType: FileMediaType): RequestBody
}

class ReadEntityToRequestBody @Inject constructor(
    private val readEntityToFile: BaseReadEntityToFile
) : BaseReadEntityToRequestBody {

    override fun map(inputModel: CreateAlifeReadEntity, fileType: FileMediaType): RequestBody {
        return RequestBody.create(
            MediaType.parse(fileType.mediaType()),
            readEntityToFile.map(inputModel)
        )
    }
}