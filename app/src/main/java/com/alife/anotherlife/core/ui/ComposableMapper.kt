package com.alife.anotherlife.core.ui

import androidx.compose.runtime.Composable

interface ComposableMapper<I, O> {

    @Composable
    fun map(value: I): O
}