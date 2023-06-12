package com.alife.data.core.exoplayer

import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.datasource.FileDataSource
import androidx.media3.datasource.cache.Cache
import androidx.media3.datasource.cache.CacheDataSink
import androidx.media3.datasource.cache.CacheDataSource
import com.alife.data.core.size.MBSize
import javax.inject.Inject

class CacheDataSourceFactory @Inject constructor(
    private val simpleCache: Cache,
    private val dataSourceFactory: DefaultDataSource.Factory
) : DataSource.Factory {

    //private val maxCacheSize = MBSize(100)
    private val maxFileSize: MBSize = MBSize(30)

    override fun createDataSource(): DataSource {
        return CacheDataSource(
            simpleCache,
            dataSourceFactory.createDataSource(),
            FileDataSource(),
            CacheDataSink(simpleCache, maxFileSize.getSize()),
            CacheDataSource.FLAG_BLOCK_ON_CACHE or CacheDataSource.FLAG_IGNORE_CACHE_ON_ERROR,
            null
        )
    }
}