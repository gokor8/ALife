package com.alife.anotherlife.di.ui.registration.email

import javax.inject.Qualifier

interface EmailAnnotation {
    
    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class EmailUIStore

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class EmailRegistration

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class EmailValidation

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class EmailChain

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class EmailTextInputChain
}