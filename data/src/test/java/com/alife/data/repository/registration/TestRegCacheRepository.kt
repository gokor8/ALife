package com.alife.data.repository.registration

import android.content.SharedPreferences
import com.alife.data.core.FakeSharedPreferences
import com.alife.data.data_source.cache.shared.SharedCacheDataSource
import com.alife.data.data_source.cache.shared.model.CacheModel
import com.alife.data.repository.registration.mapper.BaseReadCacheInputEntityToReadRegModel
import com.alife.data.repository.registration.mapper.BaseCacheInputEntityToWriteRegModel
import com.alife.domain.core.MappingException
import com.alife.domain.registration.usecase.base.entity.ReadCacheInputEntity
import com.alife.domain.registration.usecase.base.entity.RegCacheInputEntity
import com.alife.domain.registration.usecase.base.entity.SaveCacheInputEntity
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class TestRegCacheRepository {

    private lateinit var fakeSharedPreferences: FakeSharedPreferences
    private lateinit var registrationRepository: RegCacheRepository
    private lateinit var fakeCache: FakeSharedCacheDataSource


    @Before
    fun before() {
        fakeSharedPreferences = FakeSharedPreferences()
    }

    private fun setupRegistrationRepository(
        writeException: java.lang.Exception? = null,
        readException: java.lang.Exception? = null,
    ): RegCacheRepository {
        fakeCache = FakeSharedCacheDataSource(fakeSharedPreferences, writeException, readException)
        return RegCacheRepository(
            fakeCache,
            FakeBaseCacheInputEntityToSaveRegModel(),
            FakeReadCacheInputEntityToReadRegModel()
        )
    }

    @Test
    fun `test save data`() {
        registrationRepository = setupRegistrationRepository()

        registrationRepository.saveData(FakeSaveStringCacheInputEntity())

        assertEquals(fakeSharedPreferences.addedValuesList.size, 1)
        assertEquals(fakeSharedPreferences.addedValuesList.last(), "test")
    }

    @Test(expected = IllegalStateException::class)
    fun `test save exception data`() {
        registrationRepository = setupRegistrationRepository(IllegalStateException())

        registrationRepository.saveData(FakeSaveStringCacheInputEntity())

        assertEquals(fakeSharedPreferences.addedValuesList.size, 1)
    }

    @Test
    fun `test read data`() {
        fakeSharedPreferences = FakeSharedPreferences(mutableListOf("test"))
        registrationRepository = setupRegistrationRepository()

        val actual = registrationRepository.readData<String>(FakeReadStringCacheInputEntity())

        assertEquals(fakeSharedPreferences.addedValuesList.size, 1)
        assertEquals(actual, "test")
    }

    @Test(expected = IllegalStateException::class)
    fun `test read empty data exception`() {
        registrationRepository = setupRegistrationRepository(IllegalStateException())

        registrationRepository.saveData(FakeSaveStringCacheInputEntity())

        assertEquals(fakeSharedPreferences.addedValuesList.size, 1)
    }

    @Test
    fun `test save and read data`() {
        registrationRepository = setupRegistrationRepository()

        registrationRepository.saveData(FakeSaveStringCacheInputEntity())

        val actual = registrationRepository.readData<String>(FakeReadStringCacheInputEntity())

        assertEquals(fakeSharedPreferences.addedValuesList.size, 1)
        assertEquals(actual, "test")
    }
}


// Fake realization
class FakeReadStringCacheInputEntity : RegCacheInputEntity.Read<String>
class FakeSaveStringCacheInputEntity : RegCacheInputEntity.Save<String>
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

class FakeBaseCacheInputEntityToSaveRegModel : BaseCacheInputEntityToWriteRegModel {

    override fun map(inputModel: RegCacheInputEntity.Save<*>): CacheModel.Write<*> {
        return when (inputModel) {
            is FakeSaveStringCacheInputEntity -> FakeCacheWriteModel()
            else -> throw MappingException()
        }
    }
}

class FakeReadCacheInputEntityToReadRegModel : BaseReadCacheInputEntityToReadRegModel {

    override fun map(inputModel: RegCacheInputEntity.Read<*>): CacheModel.Read<*> {
        return when (inputModel) {
            is FakeReadStringCacheInputEntity -> FakeCacheReadModel()
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

    override fun delete(deleteModel: CacheModel.Read<*>) {
        TODO("Not yet implemented")
    }
}