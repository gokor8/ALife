package com.alife.data.data_source.cache.file

import com.alife.data.data_source.cache.file.base.FileWrapper
import java.io.File
import javax.inject.Inject

class OriginalFileWrapper @Inject constructor(val path: String) : FileWrapper {

    private val file = File(path)


    override fun getFile() = file

    override fun exists() = file.exists()

    override fun mkdirs() = file.mkdirs()

    override fun delete() = file.delete()

    override fun length(): Int = file.length().toInt()
}