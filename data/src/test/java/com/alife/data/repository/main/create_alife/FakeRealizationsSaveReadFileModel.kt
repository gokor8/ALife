package com.alife.data.repository.main.create_alife

import com.alife.data.data_source.cache.file.base.FileWrapper
import com.alife.data.data_source.cache.file.base.FileWrapperFactory
import com.alife.data.repository.main.create_alife.file_model_base.file_builders.BaseFileExtension
import com.alife.data.repository.main.create_alife.file_model_base.file_builders.BaseFileName
import java.io.File

class FakeFileName : BaseFileName {
    override fun getFileName() = "fake"
}

class EmptyFileName : BaseFileName {
    override fun getFileName() = ""
}

class EmptyFileExtension : BaseFileExtension {
    override fun getFileExtension() = ""
}

class FakeSaveFileWrapperFactory(
    private val isExistDir: Boolean,
    private val isExistFile: Boolean,
    private val mkdirs: Boolean = true,
    private val delete: Boolean = true
) : FileWrapperFactory {

    val fileOperationsContainer: MutableList<String> = mutableListOf()
    private val fakeFileWrapperList = mutableListOf<FakeFileWrapper>()

    override fun create(path: String): FileWrapper {
        val isExist = if((fakeFileWrapperList.size + 1) % 2 == 0) isExistFile else isExistDir

        val fileWrapper = FakeFileWrapper(
            fakeFileWrapperList.size,
            fileOperationsContainer,
            isExist,
            mkdirs,
            delete
        )
        fakeFileWrapperList.add(fileWrapper)

        return fileWrapper
    }
}

class FakeFileWrapperFactory(
    private val isExist: Boolean,
    private val mkdirs: Boolean,
    private val delete: Boolean
) : FileWrapperFactory {

    val fileOperationsContainer: MutableList<String> = mutableListOf()

    private val fakeFileWrapperList = listOf<FakeFileWrapper>()

    override fun create(path: String): FileWrapper {
        return FakeFileWrapper(
            fakeFileWrapperList.size,
            fileOperationsContainer,
            isExist,
            mkdirs,
            delete
        )
    }
}

class FakeFileWrapper(
    private val position: Int = 0,
    private val fileOperationsContainer: MutableList<String> = mutableListOf(),
    private val isExist: Boolean,
    private val mkdirs: Boolean,
    private val delete: Boolean
) : FileWrapper {

    override fun getFile(): File {
        fileOperationsContainer.add("$position getFile")
        return File("")
    }

    override fun exists(): Boolean {
        fileOperationsContainer.add("$position exists")
        return isExist
    }

    override fun mkdirs(): Boolean {
        fileOperationsContainer.add("$position mkdirs")
        return mkdirs
    }

    override fun delete(): Boolean {
        fileOperationsContainer.add("$position delete")
        return delete
    }

    override fun length(): Int {
        fileOperationsContainer.add("$position length")
        return 0
    }
}