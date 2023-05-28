package com.alife.anotherlife.di.ui.core

import javax.inject.Qualifier

interface DialogAnnotation {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class SettingsAudio

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class Camera

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class Audio
}