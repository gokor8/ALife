package com.alife.anotherlife.core.composable.text.code.model

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.core.ui.ComposableMapper

class FocusBorderMapper : ComposableMapper<Boolean, BorderStroke> {

    @Composable
    override fun map(value: Boolean): BorderStroke {
        return if(value)
            BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
        else
            BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    }
}