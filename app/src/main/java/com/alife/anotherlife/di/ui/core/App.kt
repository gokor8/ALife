package com.alife.anotherlife.di.ui.core

import android.content.Context
import dagger.Provides
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.Locale

@Module
@InstallIn(SingletonComponent::class)
class App {

    @Provides
    fun locale(@ApplicationContext appContext: Context): Locale =
        appContext.resources.configuration.locales.get(0)
}