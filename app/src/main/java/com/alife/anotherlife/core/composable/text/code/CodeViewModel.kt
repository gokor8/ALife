package com.alife.anotherlife.core.composable.text.code

import com.alife.anotherlife.core.composable.text.code.model.CodeBoxer

interface CodeViewModel : CodeBoxer {
    val limit: Int
    val maskSymbol: Char
}