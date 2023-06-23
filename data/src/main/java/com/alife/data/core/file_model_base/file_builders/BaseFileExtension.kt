package com.alife.data.core.file_model_base.file_builders

interface BaseFileExtension {

    fun getFileExtension(): String


    class Default(private val fileExtension: String) : BaseFileExtension {
        override fun getFileExtension() = ".$fileExtension"
    }
}