package com.alife.anotherlife.core.composable.map.listeners

import com.mapbox.maps.plugin.animation.CameraAnimationsPlugin
import com.mapbox.maps.plugin.animation.CameraAnimatorChangeListener

interface AddRemoveZoomMapListener : AddRemoveMapListener<CameraAnimationsPlugin> {

    class Zoom(
        private val cameraZoomListener: CameraAnimatorChangeListener<Double>
    ) : AddRemoveZoomMapListener {

        override fun addListener(model: CameraAnimationsPlugin) {
            model.addCameraZoomChangeListener(cameraZoomListener)
        }

        override fun removeListener(model: CameraAnimationsPlugin) {
            model.removeCameraZoomChangeListener(cameraZoomListener)
        }
    }

    class Bearing(
        private val bearingListener: CameraAnimatorChangeListener<Double>
    ) : AddRemoveZoomMapListener {

        override fun addListener(model: CameraAnimationsPlugin) {
            model.addCameraZoomChangeListener(bearingListener)
        }

        override fun removeListener(model: CameraAnimationsPlugin) {
            model.removeCameraZoomChangeListener(bearingListener)
        }
    }
}