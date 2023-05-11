package com.alife.data.data_source.cache.file

import com.alife.data.data_source.cache.file.base.FileWrapper
import com.alife.data.data_source.cache.file.base.FileWrapperFactory
import javax.inject.Inject

class OriginalFileWrapperFactory @Inject constructor() : FileWrapperFactory {

    override fun create(path: String): FileWrapper {
        return OriginalFileWrapper(path)
    }
}