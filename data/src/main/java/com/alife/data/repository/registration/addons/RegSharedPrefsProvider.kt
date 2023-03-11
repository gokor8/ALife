package com.alife.data.repository.registration.addons

import android.content.Context
import android.content.SharedPreferences

class RegSharedPrefsProvider : SharedPreferencesProvider {

    private val name: String = "registration"
    private val mode = Context.MODE_PRIVATE

    override fun provideSharedPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(name, mode)
    }
}