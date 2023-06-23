package com.alife.data.data_source.cache.file.base

interface FileWrapperFactory {

    fun create(path: String): FileWrapper
}