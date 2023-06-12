package com.alife.anotherlife.di.data.core.exoplayer

import android.content.Context
import androidx.media3.database.StandaloneDatabaseProvider
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.datasource.cache.Cache
import androidx.media3.datasource.cache.LeastRecentlyUsedCacheEvictor
import androidx.media3.datasource.cache.SimpleCache
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter
import com.alife.data.core.exoplayer.ExoplayerCacheDirectory
import com.alife.data.core.size.MBSize
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
class ExoPlayerModuleP {

    @Provides
    @androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
    fun provideSimpleCache(
        @ApplicationContext
        context: Context,
        exoplayerCacheDirectory: ExoplayerCacheDirectory
    ): Cache = SimpleCache(
        exoplayerCacheDirectory.createFile(),
        LeastRecentlyUsedCacheEvictor(MBSize(200).getSize()),
        StandaloneDatabaseProvider(context)
    )

    @Provides
    @androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
    fun provideDefaultDataSourceFactory(
        @ApplicationContext
        context: Context,
    ) = DefaultDataSource.Factory(
        context,
        DefaultHttpDataSource.Factory()
    ).setTransferListener(
        DefaultBandwidthMeter.Builder(context).build()
    )
}