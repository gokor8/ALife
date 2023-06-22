package com.alife.anotherlife.ui.screen.main.navigation_bar.map

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.model.MapElementModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.model.UIMapPost
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.state.MapEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.state.MapState

interface BaseMapReducer : BaseVMReducer<MapState, MapEffect> {

    suspend fun onInit()

    suspend fun onOpenDetailScreen(username: String)

    suspend fun onMapPermissionGranted()

    suspend fun onMapPermissionFatal()

    suspend fun getMapPosts()

    suspend fun onSaveSelected(mapElementModel: MapElementModel)
}