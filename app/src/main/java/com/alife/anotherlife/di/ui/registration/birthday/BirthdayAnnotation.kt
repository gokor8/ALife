package com.alife.anotherlife.di.ui.registration.birthday

import javax.inject.Qualifier


interface BirthdayAnnotation {

    @Qualifier
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class BirthdayUIStore

    @Qualifier
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class BirthdayRegistration

    @Qualifier
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class BirthdayValidation

    @Qualifier
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class BirthdayChain
}