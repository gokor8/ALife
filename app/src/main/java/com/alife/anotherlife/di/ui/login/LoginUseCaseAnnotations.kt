package com.alife.anotherlife.di.ui.login

import javax.inject.Qualifier

sealed interface LoginUseCaseAnnotations {

    @Qualifier
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class LoginATUseCase

    @Qualifier
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class MockATUseCase

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class UseCaseList
}