package com.alife.data.data_source

import android.content.SharedPreferences
import com.alife.data.data_source.model.CacheModel

interface SharedCacheDataSource {

    fun save(saveModel: CacheModel.Write<*>)

    fun<M> read(cacheModel: CacheModel.Read<M>): M


    abstract class AbstractSharedCacheDataSource(
        protected val sharedPreferences: SharedPreferences
    ) : SharedCacheDataSource {

        override fun save(saveModel: CacheModel.Write<*>) {
            val editor = sharedPreferences.edit()
            saveModel.write(editor)
            editor.apply()
        }

        override fun<M> read(cacheModel: CacheModel.Read<M>): M {
            return cacheModel.read(sharedPreferences)
        }
    }
}