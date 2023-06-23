package com.alife.data.core.file_model_base.file_builders

interface BaseFileName {
    fun getFileName(): String


    class Default(private val name: String) : BaseFileName {
        override fun getFileName() = name
    }
}