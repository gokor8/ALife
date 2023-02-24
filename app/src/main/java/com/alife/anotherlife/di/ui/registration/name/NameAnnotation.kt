package com.alife.anotherlife.di.ui.registration.name

import javax.inject.Qualifier

class NameAnnotation {

    @Qualifier
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class NameUIStore

    @Qualifier
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class NameRegistration

    @Qualifier
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class BirthdayValidation

    @Qualifier
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class BirthdayChain
}