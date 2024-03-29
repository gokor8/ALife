package com.alife.data.repository.main.create_alife

import com.alife.data.data_source.cache.file.OriginalFileWrapperFactory
import com.alife.data.core.file_model_base.BaseReadFileModel
import com.alife.data.core.file_model_base.file_builders.BaseFileName
import com.alife.data.repository.main.create_alife.picture.model.image.JpegExtension
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.io.BufferedInputStream
import java.io.FileNotFoundException

class TestReadDefaultModelCreateAlife {

    @Test(expected = FileNotFoundException::class)
    fun `test read file none exist`() {
        val readFileModel = FakeRead(FakeFileName())

        val `in` = BufferedInputStream(null)
        val fileWrapperFactory =
            FakeFileWrapperFactory(isExist = false, mkdirs = true, delete = true)

        val readByteArray = readFileModel.readFromFile(`in`, fileWrapperFactory)

        assertEquals(1, fileWrapperFactory.fileOperationsContainer.size)
        assertEquals("exists", fileWrapperFactory.fileOperationsContainer[0])
        assertEquals(0, readByteArray.size)
    }

    @Test
    fun `test read file exist`() {
        val readFileModel = FakeRead(FakeFileName())

        val `in` = BufferedInputStream(null)
        val fileWrapperFactory =
            FakeFileWrapperFactory(isExist = true, mkdirs = true, delete = true)

        val readByteArray = readFileModel.readFromFile(`in`, fileWrapperFactory)

        assertEquals(2, fileWrapperFactory.fileOperationsContainer.size)
        assertEquals("0 exists", fileWrapperFactory.fileOperationsContainer[0])
        assertEquals("0 length", fileWrapperFactory.fileOperationsContainer[1])
        // 0 это позиция и количественный номер созданного файла
        assertEquals(0, readByteArray.size)
    }

    @Test(expected = FileNotFoundException::class)
    fun `test read file when path empty`() {
        val readFileModel = FakeReadEmpty()

        val `in` = BufferedInputStream(null)
        val fileWrapperFactory = OriginalFileWrapperFactory()

        readFileModel.readFromFile(`in`, fileWrapperFactory)
    }

    // Fake Realization
    class FakeReadEmpty : BaseReadFileModel.DefaultRead(
        TestPathOfAbstract.FakeFilePath(),
        EmptyFileName(),
        EmptyFileExtension()
    )

    class FakeRead(fileName: BaseFileName) : BaseReadFileModel.DefaultRead(
        TestPathOfAbstract.FakeFilePath(),
        fileName,
        JpegExtension()
    )
}