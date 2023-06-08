package com.alife.data.repository.main.profile.mapper

import com.alife.core.mapper.Mapper
import javax.inject.Inject

interface BaseFileNameToSeparate : Mapper<String, Pair<String, String>>

class FileNameToSeparate @Inject constructor() : BaseFileNameToSeparate {

    private val fileDelimiter = "."

    override fun map(inputModel: String): Pair<String, String> = with(inputModel) {
        Pair(substringBefore(fileDelimiter), substringAfter(fileDelimiter))
    }
}