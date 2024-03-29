package com.alife.core.addons

import java.io.Reader

interface JsonWrapper {

    fun toJson(`object`: Any): String

    fun<T> fromJson(json: Reader?, classOfT: Class<T>): T

    fun<T> fromJson(json: String, classOfT: Class<T>): T
}