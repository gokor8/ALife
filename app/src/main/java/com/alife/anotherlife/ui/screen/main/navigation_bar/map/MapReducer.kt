package com.alife.anotherlife.ui.screen.main.navigation_bar.map

import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.mapper.BaseMapPostEntityToUI
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.model.LceErrorMapPermissionProvider
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.model.MapElementModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.state.MapEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.state.MapState
import com.alife.domain.main.map.BaseMapPostUseCase
import javax.inject.Inject

class MapReducer @Inject constructor(
    override val uiStore: UIStore<MapState, MapEffect>,
    private val mapPostUseCase: BaseMapPostUseCase,
    private val mapPostEntityToUI: BaseMapPostEntityToUI
) : AbstractVMReducer<MapState, MapEffect>(), BaseMapReducer {

    override suspend fun onInit() {
        val uiMapPosts = mapPostEntityToUI.map(mapPostUseCase.getMapPosts())

        uiStore.setState { copy(mapPosts = uiMapPosts) }
    }

    override suspend fun onOpenDetailScreen(username: String) {
        setEffect(MapEffect.OpenDetailScreen(username))
    }

    override suspend fun onMapPermissionGranted() {
        setState { copy(lceModel = LCEContent) }
    }

    override suspend fun onMapPermissionFatal() {
        setState { copy(lceModel = LceErrorMapPermissionProvider) }
    }

    override suspend fun getMapPosts() {
        val uiMapPostList = mapPostEntityToUI.map(mapPostUseCase.getMapPosts())

        setState { copy(mapPosts = uiMapPostList) }
    }

    override suspend fun onSaveSelected(mapElementModel: MapElementModel) {
        setState { copy(selected = mapElementModel) }
    }
}