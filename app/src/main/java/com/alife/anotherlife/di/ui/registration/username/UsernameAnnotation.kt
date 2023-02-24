package com.alife.anotherlife.di.ui.registration.username

import javax.inject.Qualifier

interface UsernameAnnotation {

    @Qualifier
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class  UsernameUIStore

    @Qualifier
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class  UsernameRegistration

    @Qualifier
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class  UsernameValidation

    @Qualifier
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class  UsernameChain
}