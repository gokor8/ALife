package com.alife.data.data_source.model

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

interface CacheModel<M> {

    fun getKey(): String


    interface Read<M> : CacheModel<M> {

        fun read(sharedPreferences: SharedPreferences): M
    }

    interface Write<M> : CacheModel<M> {

        fun write(editor: Editor)
    }
}