package com.alife.data.repository.registration.model

import android.content.SharedPreferences
import com.alife.data.data_source.model.AbstractCacheModel
import com.alife.data.data_source.model.CacheModel

abstract class StringCacheWrite(
    keyCacheModel: CacheModel<String>,
    saveValue: String,
) : AbstractCacheModel.Write<String>(keyCacheModel.getKey(), saveValue) {

    override fun write(editor: SharedPreferences.Editor) {
        editor.putString(getKey(), saveValue)
    }
}

abstract class StringCacheRead(
    keyCacheModel: CacheModel<String>
) : AbstractCacheModel.Read<String>(keyCacheModel.getKey()) {

    abstract fun onReadNull(): String

    override fun defaultValue(): String = ""

    override fun read(sharedPreferences: SharedPreferences): String {
        return sharedPreferences.getString(getKey(), null) ?: onReadNull()
    }
}