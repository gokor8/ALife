package com.alife.anotherlife.core.composable.text.code.model

sealed class CodeModel(val code: String) {

    abstract fun copy(code: String): CodeModel


    class Init : CodeModel("") {
        override fun copy(code: String) = Filling(code)
    }

    class Filling(code: String) : CodeModel(code) {
        fun isFill(limit: Int) = code.length == limit

        override fun copy(code: String) = Filling(code = code)
    }
}