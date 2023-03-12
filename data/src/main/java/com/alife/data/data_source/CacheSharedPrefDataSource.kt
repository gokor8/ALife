package com.alife.data.data_source

import android.content.SharedPreferences
import javax.inject.Inject

class CacheSharedPrefDataSource @Inject constructor(
    sharedPreferences: SharedPreferences
) : SharedCacheDataSource.AbstractSharedCacheDataSource(sharedPreferences)