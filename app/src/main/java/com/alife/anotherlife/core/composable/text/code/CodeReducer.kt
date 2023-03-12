package com.alife.anotherlife.core.composable.text.code

interface CodeReducer {

    suspend fun onCode(code: String)
}