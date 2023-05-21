package com.alife.data.core

import com.alife.core.addons.JsonWrapper
import com.google.gson.Gson
import java.io.Reader
import javax.inject.Inject

class GsonWrapper @Inject constructor(private val gson: Gson) : JsonWrapper {

    override fun toJson(`object`: Any) = gson.toJson(`object`)

    override fun <T> fromJson(json: Reader?, classOfT: Class<T>) = gson.fromJson(json, classOfT)
}