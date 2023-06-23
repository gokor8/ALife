package com.alife.anotherlife.di.ui.registration.birthday

import javax.inject.Qualifier


interface BirthdayAnnotation {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class BirthdayUIStore

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class BirthdayRegistration

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class BirthdayValidation

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class BirthdayChain
}