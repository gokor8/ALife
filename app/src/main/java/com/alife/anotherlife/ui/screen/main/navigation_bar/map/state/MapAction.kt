package com.alife.anotherlife.ui.screen.main.navigation_bar.map.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.BaseMapReducer

interface MapAction : BaseMVIAction<BaseMapReducer> {

    class Init : MapAction {
        override suspend fun onAction(reducer: BaseMapReducer) {
            reducer.onInit()
        }
    }

    class MapPermissionGranted : MapAction {
        override suspend fun onAction(reducer: BaseMapReducer) {
            reducer.onMapPermissionGranted()
        }
    }

    class MapPermissionFatal : MapAction {
        override suspend fun onAction(reducer: BaseMapReducer) {
            reducer.onMapPermissionFatal()
        }
    }
}