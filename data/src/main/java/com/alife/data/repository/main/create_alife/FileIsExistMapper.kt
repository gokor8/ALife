package com.alife.data.repository.main.create_alife

import com.alife.core.mapper.Mapper
import com.alife.data.data_source.cache.file.OriginalFileWrapper
import java.io.File
import javax.inject.Inject

interface BaseFileIsExistMapper : Mapper<String, String>

class FileIsExistMapper @Inject constructor() : BaseFileIsExistMapper {

    override fun map(inputModel: String): String {
        if(!File(inputModel).exists()) throw NoFileException()

        return inputModel
    }
}