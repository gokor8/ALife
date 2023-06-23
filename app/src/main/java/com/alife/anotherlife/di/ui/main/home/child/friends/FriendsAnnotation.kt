package com.alife.anotherlife.di.ui.main.home.child.friends

import javax.inject.Qualifier

class FriendsAnnotation {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class FriendsUIStore

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class FriendsProfileUseCase
}