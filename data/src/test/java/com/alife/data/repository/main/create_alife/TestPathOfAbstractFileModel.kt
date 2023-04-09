package com.alife.data.repository.main.create_alife

import com.alife.data.repository.main.create_alife.model.base.BaseFileModel
import com.alife.data.repository.main.create_alife.model.base.file_builders.BaseFileName
import com.alife.data.repository.main.create_alife.model.base.file_builders.BasePathModel
import com.alife.data.repository.main.create_alife.model.file.BackAlifeFileName
import com.alife.data.repository.main.create_alife.model.file.FrontAlifeFileName
import com.alife.data.repository.main.create_alife.model.image.JpegExtension
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

class TestPathOfAbstractFileModel {

    private val testFrontSaveModel = FakeFileModel(FrontAlifeFileName())
    private val testBackSaveModel = FakeFileModel(BackAlifeFileName())

    @Test
    fun `test front file path`() {
        val actual = testFrontSaveModel.getFullFilePath()

        val expected = "/front.jpeg"

        assertTrue(actual.contains(expected))
        assertEquals(expected, actual)
    }

    @Test
    fun `test back file path`() {
        val actual = testBackSaveModel.getFullFilePath()

        val expected = "/back.jpeg"

        assertTrue(actual.contains(expected))
        assertEquals(expected, actual)
    }


    // Fake Realization
    class FakeFilePath : BasePathModel {
        override fun getPath(): String = ""
    }

    class FakeFileModel(
        fileName: BaseFileName
    ) : BaseFileModel.AbstractFileModel(FakeFilePath(), fileName, JpegExtension())
}