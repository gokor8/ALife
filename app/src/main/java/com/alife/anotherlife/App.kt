package com.alife.anotherlife

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        //MapKitFactory.setApiKey()
    }
}