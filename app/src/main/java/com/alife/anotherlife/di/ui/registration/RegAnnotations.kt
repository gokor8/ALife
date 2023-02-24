package com.alife.anotherlife.di.ui.registration

import javax.inject.Qualifier

interface RegAnnotations {

    @Qualifier
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class NameValidationReducer

    @Qualifier
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class UsernameValidationReducer

    // UIStore
    @Qualifier
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class RegNameUIStore

    @Qualifier
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class RegUsernameUIStore
}