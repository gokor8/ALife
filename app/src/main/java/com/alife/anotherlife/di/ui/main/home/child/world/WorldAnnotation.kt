package com.alife.anotherlife.di.ui.main.home.child.world

import javax.inject.Qualifier

interface WorldAnnotation {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class WorldUIStore

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class WorldProfileUseCase
}