package com.alife.data.data_source.cache.shared

import android.content.SharedPreferences
import javax.inject.Inject

class CacheSharedPrefDataSource @Inject constructor(
    sharedPreferences: SharedPreferences
) : SharedCacheDataSource.AbstractSharedCacheDataSource(sharedPreferences)