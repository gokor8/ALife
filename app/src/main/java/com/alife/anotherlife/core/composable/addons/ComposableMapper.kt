package com.alife.anotherlife.core.composable.addons

import androidx.compose.runtime.Composable

interface ComposableMapper<I, O> {

    @Composable
    fun map(value: I): O
}