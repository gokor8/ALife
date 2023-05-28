package com.alife.data.repository.main.create_alife

import com.alife.core.mapper.Mapper
import com.alife.data.repository.main.finish_create_alife.mapper.BaseFileIsExistMapper
import java.io.File
import javax.inject.Inject

interface BasePathIsExistMapper : Mapper<String, String>

class PathFileIsExistMapper @Inject constructor() : BasePathIsExistMapper {

    override fun map(inputModel: String): String {
        if(!File(inputModel).exists()) throw NoFileException()

        return inputModel
    }
}