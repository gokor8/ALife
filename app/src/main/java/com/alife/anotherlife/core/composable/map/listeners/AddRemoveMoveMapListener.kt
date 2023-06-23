package com.alife.anotherlife.core.composable.map.listeners

import com.mapbox.maps.plugin.gestures.GesturesPlugin

class AddRemoveMoveMapListener(
    private val moveMapUserListener: MoveMapUserListener
) : AddRemoveMapListener<GesturesPlugin> {

    override fun addListener(model: GesturesPlugin) {
        model.addOnMoveListener(moveMapUserListener)
    }

    override fun removeListener(model: GesturesPlugin) {
        model.removeOnMoveListener(moveMapUserListener)
    }
}

class AddRemoveMoveLocationMapListener(
    private val cameraMoveListener: OnCameraMoveListener
) : AddRemoveMapListener<GesturesPlugin> {

    override fun addListener(model: GesturesPlugin) {
        model.addOnMoveListener(cameraMoveListener)
    }

    override fun removeListener(model: GesturesPlugin) {
        model.removeOnMoveListener(cameraMoveListener)
    }
}