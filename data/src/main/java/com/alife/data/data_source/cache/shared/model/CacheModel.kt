package com.alife.data.data_source.cache.shared.model

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

interface CacheModel<M> {

    fun getKey(): String


    interface Read<M> : CacheModel<M> {

        fun read(sharedPreferences: SharedPreferences): M

        fun delete(editor: Editor) { editor.remove(getKey()) }
    }

    interface Write<M> : CacheModel<M> {

        fun write(editor: Editor)
    }
}