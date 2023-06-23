package com.alife.anotherlife.ui.screen.main.navigation_bar.map.mapper

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.ui.screen.LceContentMapper
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.model.LceErrorMapPermission
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.model.LceErrorMapPermissionProvider

class LceErrorMapMapper {

    private val defaultErrorMapper = LceContentMapper.Default()

    @Composable
    fun Map(lceModel: LCEModel, modifier: Modifier, onRetry: () -> Unit) {
        when(lceModel) {
            is LceErrorMapPermissionProvider -> LceErrorMapPermission().LCEContent(modifier, onRetry)
            else -> defaultErrorMapper.Map(lceModel, modifier)
        }
    }
}