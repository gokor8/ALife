package com.alife.anotherlife.di.ui.registration.username

import javax.inject.Qualifier

interface UsernameAnnotation {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class UsernameUIStore

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class UsernameRegistration

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class UsernameValidation

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class UsernameChain

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class UsernameAccessSymbolArray

}