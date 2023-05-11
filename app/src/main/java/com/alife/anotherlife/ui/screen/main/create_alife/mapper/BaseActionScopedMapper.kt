package com.alife.anotherlife.ui.screen.main.create_alife.mapper

import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import kotlinx.coroutines.CoroutineScope

interface BaseActionScopedMapper {
    fun map(action: CreateAlifeAction, viewModelScope: CoroutineScope): CreateAlifeAction
}