package com.alife.data.repository.registration

import android.content.SharedPreferences
import com.alife.data.core.FakeSharedPreferences
import com.alife.data.data_source.SharedCacheDataSource
import com.alife.data.data_source.model.CacheModel
import com.alife.data.repository.registration.mapper.BaseRegEntityToReadRegModel
import com.alife.data.repository.registration.mapper.BaseRegEntityToWriteRegModel
import com.alife.domain.core.MappingException
import com.alife.domain.registration.core.entity.RegInputEntity
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class TestRegistrationRepository {

    private lateinit var fakeSharedPreferences: FakeSharedPreferences
    private lateinit var registrationRepository: RegistrationRepository
    private lateinit var fakeCache: FakeSharedCacheDataSource


    @Before
    fun before() {
        fakeSharedPreferences = FakeSharedPreferences()
    }

    private fun setupRegistrationRepository(
        writeException: java.lang.Exception? = null,
        readException: java.lang.Exception? = null,
    ): RegistrationRepository {
        fakeCache = FakeSharedCacheDataSource(fakeSharedPreferences, writeException, readException)
        return RegistrationRepository(
            fakeCache,
            FakeBaseRegEntityToWriteRegModel(),
            FakeRegEntityToReadRegModel()
        )
    }

    @Test
    fun `test save data`() {
        registrationRepository = setupRegistrationRepository()

        registrationRepository.saveRegData(FakeStringRegInputEntity())

        assertEquals(fakeSharedPreferences.addedValuesList.size, 1)
        assertEquals(fakeSharedPreferences.addedValuesList.last(), "test")
    }

    @Test(expected = IllegalStateException::class)
    fun `test save exception data`() {
        registrationRepository = setupRegistrationRepository(IllegalStateException())

        registrationRepository.saveRegData(FakeStringRegInputEntity())

        assertEquals(fakeSharedPreferences.addedValuesList.size, 1)
    }

    @Test
    fun `test read data`() {
        fakeSharedPreferences = FakeSharedPreferences(mutableListOf("test"))
        registrationRepository = setupRegistrationRepository()

        val actual = registrationRepository.readRegData(FakeStringRegInputEntity())

        assertEquals(fakeSharedPreferences.addedValuesList.size, 1)
        assertEquals(actual, "test")
    }

    @Test(expected = IllegalStateException::class)
    fun `test read empty data exception`() {
        registrationRepository = setupRegistrationRepository(IllegalStateException())

        registrationRepository.saveRegData(FakeStringRegInputEntity())

        assertEquals(fakeSharedPreferences.addedValuesList.size, 1)
    }

    @Test
    fun `test save and read data`() {
        registrationRepository = setupRegistrationRepository()

        registrationRepository.saveRegData(FakeStringRegInputEntity())

        val actual = registrationRepository.readRegData(FakeStringRegInputEntity())

        assertEquals(fakeSharedPreferences.addedValuesList.size, 1)
        assertEquals(actual, "test")
    }
}


// Fake realization
class FakeStringRegInputEntity : RegInputEntity<String>
class FakeCacheWriteModel : CacheModel.Write<String> {

    override fun getKey(): String = "test"

    override fun write(editor: SharedPreferences.Editor) {
        editor.putString(getKey(), "test")
    }
}

class FakeCacheReadModel : CacheModel.Read<String> {

    override fun getKey(): String = "test"

    override fun read(sharedPreferences: SharedPreferences): String =
        sharedPreferences.getString(getKey(), null) ?: throw IllegalStateException()
}

class FakeBaseRegEntityToWriteRegModel : BaseRegEntityToWriteRegModel {

    override fun map(inputModel: RegInputEntity<*>): CacheModel.Write<*> {
        return when (inputModel) {
            is FakeStringRegInputEntity -> FakeCacheWriteModel()
            else -> throw MappingException()
        }
    }
}

class FakeRegEntityToReadRegModel : BaseRegEntityToReadRegModel {

    override fun map(inputModel: RegInputEntity<*>): CacheModel.Read<*> {
        return when (inputModel) {
            is FakeStringRegInputEntity -> FakeCacheReadModel()
            else -> throw MappingException()
        }
    }
}

class FakeSharedCacheDataSource(
    private val sharedPreferences: FakeSharedPreferences,
    private val writeException: java.lang.Exception?,
    private val readException: java.lang.Exception?,
) : SharedCacheDataSource {

    override fun save(saveModel: CacheModel.Write<*>) {
        writeException?.apply { throw writeException }
        saveModel.write(sharedPreferences.edit())
    }

    override fun <M> read(cacheModel: CacheModel.Read<M>): M {
        readException?.apply { throw readException }
        return cacheModel.read(sharedPreferences)
    }
}