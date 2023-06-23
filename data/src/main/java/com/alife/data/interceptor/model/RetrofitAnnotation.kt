package com.alife.data.interceptor.model

import javax.inject.Qualifier

interface RetrofitAnnotation {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class BaseUrl
}