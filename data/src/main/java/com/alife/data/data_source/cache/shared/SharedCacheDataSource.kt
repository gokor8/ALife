package com.alife.data.data_source.cache.shared

import android.content.SharedPreferences
import com.alife.data.data_source.cache.shared.model.CacheModel

interface SharedCacheDataSource {

    fun save(saveModel: CacheModel.Write<*>)

    fun<M> read(cacheModel: CacheModel.Read<M>): M

    fun delete(deleteModel: CacheModel.Read<*>)


    abstract class AbstractSharedCacheDataSource(
        private val sharedPreferences: SharedPreferences
    ) : SharedCacheDataSource {

        override fun save(saveModel: CacheModel.Write<*>) {
            val editor = sharedPreferences.edit()
            saveModel.write(editor)
            editor.apply()
        }

        override fun<M> read(cacheModel: CacheModel.Read<M>): M {
            return cacheModel.read(sharedPreferences)
        }

        override fun delete(deleteModel: CacheModel.Read<*>) {
            val editor = sharedPreferences.edit()
            deleteModel.delete(editor)
            editor.apply()
        }
    }
}