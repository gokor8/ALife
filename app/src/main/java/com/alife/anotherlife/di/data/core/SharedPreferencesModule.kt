package com.alife.anotherlife.di.data.core

import android.content.Context
import android.content.SharedPreferences
import com.alife.data.repository.registration.addons.RegSharedPrefsProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SharedPreferencesModule {

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return RegSharedPrefsProvider().provideSharedPrefs(context)
    }
}