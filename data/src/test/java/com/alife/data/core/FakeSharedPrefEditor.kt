package com.alife.data.core

import android.content.SharedPreferences

class FakeSharedPrefEditor(private val addedValuesList: MutableList<Any>) : SharedPreferences.Editor {

    override fun putString(key: String?, value: String?): SharedPreferences.Editor {
        value?.also { addedValuesList.add(value) }
        return this
    }

    override fun putStringSet(key: String?, values: MutableSet<String>?): SharedPreferences.Editor {
        TODO("Not yet implemented")
    }

    override fun putInt(key: String?, value: Int): SharedPreferences.Editor {
        TODO("Not yet implemented")
    }

    override fun putLong(key: String?, value: Long): SharedPreferences.Editor {
        TODO("Not yet implemented")
    }

    override fun putFloat(key: String?, value: Float): SharedPreferences.Editor {
        TODO("Not yet implemented")
    }

    override fun putBoolean(key: String?, value: Boolean): SharedPreferences.Editor {
        TODO("Not yet implemented")
    }

    override fun remove(key: String?): SharedPreferences.Editor {
        TODO("Not yet implemented")
    }

    override fun clear(): SharedPreferences.Editor {
        TODO("Not yet implemented")
    }

    override fun commit(): Boolean = true

    override fun apply() {}
}