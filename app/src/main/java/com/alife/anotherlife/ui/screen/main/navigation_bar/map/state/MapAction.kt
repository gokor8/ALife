package com.alife.anotherlife.ui.screen.main.navigation_bar.map.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.BaseMapReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.model.MapElementModel

interface MapAction : BaseMVIAction<BaseMapReducer> {

    class Init : MapAction {
        override suspend fun onAction(reducer: BaseMapReducer) {
            reducer.onInit()
        }
    }

    class OpenDetailScreen(private val username: String) : MapAction {
        override suspend fun onAction(reducer: BaseMapReducer) {
            reducer.onOpenDetailScreen(username)
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

    class SaveLastSelected(private val mapElementModel: MapElementModel) : MapAction {
        override suspend fun onAction(reducer: BaseMapReducer) {
            reducer.onSaveSelected(mapElementModel)
        }
    }
}