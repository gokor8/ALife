package com.alife.data.repository.main.create_alife

import com.alife.data.data_source.cache.file.base.FileWrapperFactory
import com.alife.data.core.file_model_base.BaseSaveFileModel
import com.alife.data.core.file_model_base.file_builders.BaseFileName
import com.alife.data.repository.main.create_alife.picture.model.image.JpegExtension
import junit.framework.TestCase
import org.junit.Test
import java.io.FileOutputStream

class TestSaveDefaultModelCreateAlife {

    @Test
    fun `test create file and dir exist`() {
        val fileWrapperFactory = FakeSaveFileWrapperFactory(isExistDir = true, isExistFile = true)
        val saveFileModel = FakeSaveFileModel(FakeFileName(), fileWrapperFactory)

        saveFileModel.createFile()

        TestCase.assertEquals(4, fileWrapperFactory.fileOperationsContainer.size)
        TestCase.assertEquals("0 exists", fileWrapperFactory.fileOperationsContainer[0])
        TestCase.assertEquals("1 exists", fileWrapperFactory.fileOperationsContainer[1])
        TestCase.assertEquals("1 delete", fileWrapperFactory.fileOperationsContainer[2])
        TestCase.assertEquals("1 getFile", fileWrapperFactory.fileOperationsContainer.last())
    }

    @Test
    fun `test create file none exist`() {
        val fileWrapperFactory = FakeSaveFileWrapperFactory(isExistDir = true, isExistFile = false)
        val saveFileModel = FakeSaveFileModel(FakeFileName(), fileWrapperFactory)

        saveFileModel.createFile()

        TestCase.assertEquals(3, fileWrapperFactory.fileOperationsContainer.size)
        TestCase.assertEquals("0 exists", fileWrapperFactory.fileOperationsContainer[0])
        TestCase.assertEquals("1 exists", fileWrapperFactory.fileOperationsContainer[1])
        TestCase.assertEquals("1 getFile", fileWrapperFactory.fileOperationsContainer.last())
    }

    @Test
    fun `test create file none exist dir`() {
        val fileWrapperFactory = FakeSaveFileWrapperFactory(isExistDir = false, isExistFile = false)
        val saveFileModel = FakeSaveFileModel(FakeFileName(), fileWrapperFactory)

        saveFileModel.createFile()

        TestCase.assertEquals(4, fileWrapperFactory.fileOperationsContainer.size)
        // 0 это позиция и количественный номер созданного файла
        TestCase.assertEquals("0 exists", fileWrapperFactory.fileOperationsContainer[0])
        TestCase.assertEquals("0 mkdirs", fileWrapperFactory.fileOperationsContainer[1])
        TestCase.assertEquals("1 exists", fileWrapperFactory.fileOperationsContainer[2])
        TestCase.assertEquals("1 getFile", fileWrapperFactory.fileOperationsContainer.last())
    }

    // Fake Realization
    class FakeSaveFileModel(
        fileName: BaseFileName,
        fileWrapperFactory: FileWrapperFactory
    ) : BaseSaveFileModel.DefaultSave(
        TestPathOfAbstractFileModel.FakeFilePath(),
        fileName,
        JpegExtension(),
        fileWrapperFactory
    ) {
        override fun writeToFile(fileOutputStream: FileOutputStream) {}
    }
}