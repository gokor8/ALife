package com.alife.anotherlife.ui.screen.main.navigation_bar.map

import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.model.LceErrorMapPermissionProvider
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.state.MapEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.state.MapState
import javax.inject.Inject

class MapReducer @Inject constructor(
    override val uiStore: UIStore<MapState, MapEffect>
) : AbstractVMReducer<MapState, MapEffect>(), BaseMapReducer {

    override suspend fun onMapPermissionGranted() {
        setState { copy(lceModel = LCEContent) }
    }

    override suspend fun onMapPermissionFatal() {
        setState { copy(lceModel = LceErrorMapPermissionProvider) }
    }
}