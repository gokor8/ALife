package com.alife.data.repository.registration.addons

import android.content.Context
import android.content.SharedPreferences

interface SharedPreferencesProvider {

    fun provideSharedPrefs(context: Context): SharedPreferences
}