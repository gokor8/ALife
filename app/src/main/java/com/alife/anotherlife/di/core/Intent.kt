package com.alife.anotherlife.di.core

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
class IntentModule {

    companion object {
        fun Context.settingsIntent() = Intent().apply {
            action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
            data = Uri.fromParts("package", packageName, null)
        }
    }

    @IntentAnnotation.Settings
    @Provides
    fun provideSettingsAppIntent(@ApplicationContext context: Context) = context.settingsIntent()


    interface IntentAnnotation {
        @Qualifier
        @Retention(AnnotationRetention.RUNTIME)
        annotation class Settings
    }
}