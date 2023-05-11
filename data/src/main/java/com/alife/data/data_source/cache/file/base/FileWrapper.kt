package com.alife.data.data_source.cache.file.base

import java.io.File

interface FileWrapper {

    fun getFile(): File

    fun exists(): Boolean

    fun mkdirs(): Boolean

    fun delete(): Boolean

    fun length(): Int
}