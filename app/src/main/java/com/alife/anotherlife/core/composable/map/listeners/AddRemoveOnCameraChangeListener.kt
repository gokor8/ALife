package com.alife.anotherlife.core.composable.map.listeners

import com.mapbox.maps.MapboxMap
import com.mapbox.maps.plugin.delegates.listeners.OnCameraChangeListener

class AddRemoveOnCameraChangeListener(
    private val onCameraChangeListener: OnCameraChangeListener
) : AddRemoveMapListener<MapboxMap> {

    override fun addListener(model: MapboxMap) {
        model.addOnCameraChangeListener(onCameraChangeListener)
    }

    override fun removeListener(model: MapboxMap) {
        model.removeOnCameraChangeListener(onCameraChangeListener)
    }
}