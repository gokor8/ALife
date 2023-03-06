package com.alife.data.repository.registration.model

import android.content.SharedPreferences

abstract class RegistrationModel(
    protected val key: String
) {
    abstract fun saveValue(spEditor: SharedPreferences.Editor)
}