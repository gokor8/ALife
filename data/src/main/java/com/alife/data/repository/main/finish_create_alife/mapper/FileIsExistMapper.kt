package com.alife.data.repository.main.finish_create_alife.mapper

import com.alife.core.mapper.Mapper
import com.alife.data.core.NoFileException
import java.io.File
import javax.inject.Inject

interface BaseFileIsExistMapper : Mapper<File, File>

class FileIsExistMapper @Inject constructor(): BaseFileIsExistMapper {

    override fun map(inputModel: File) =
        if (!inputModel.exists()) throw NoFileException() else inputModel
}