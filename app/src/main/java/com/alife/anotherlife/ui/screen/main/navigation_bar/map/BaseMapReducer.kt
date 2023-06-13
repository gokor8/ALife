package com.alife.anotherlife.ui.screen.main.navigation_bar.map

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.state.MapEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.state.MapState

interface BaseMapReducer : BaseVMReducer<MapState, MapEffect> {

    fun onInit() {
        setState { copy(lceModel = LCELoading) }
    }

    suspend fun onMapPermissionGranted()

    suspend fun onMapPermissionFatal()
}