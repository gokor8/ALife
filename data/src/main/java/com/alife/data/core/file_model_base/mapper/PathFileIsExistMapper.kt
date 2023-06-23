package com.alife.data.core.file_model_base.mapper

import com.alife.core.mapper.Mapper
import com.alife.data.core.NoFileException
import java.io.File
import javax.inject.Inject

interface BasePathIsExistMapper : Mapper<String, String>

class PathFileIsExistMapper @Inject constructor() : BasePathIsExistMapper {

    override fun map(inputModel: String): String {
        if(!File(inputModel).exists()) throw NoFileException()

        return inputModel
    }
}