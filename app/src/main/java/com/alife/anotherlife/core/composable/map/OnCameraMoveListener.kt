package com.alife.anotherlife.core.composable.map

import com.mapbox.android.gestures.MoveGestureDetector
import com.mapbox.maps.plugin.gestures.GesturesPlugin
import com.mapbox.maps.plugin.gestures.OnMoveListener
import com.mapbox.maps.plugin.locationcomponent.LocationComponentPlugin

class OnCameraMoveListener(
    private val position: AddRemoveLocationChangedListener.Position,
    private val bearing: AddRemoveLocationChangedListener.Bearing,
    private val location: LocationComponentPlugin,
    private val gestures: GesturesPlugin
) : OnMoveListener {

    override fun onMove(detector: MoveGestureDetector) = false

    override fun onMoveBegin(detector: MoveGestureDetector) {
        position.removeOnIndicatorListener(location)
        bearing.removeOnIndicatorListener(location)
        gestures.removeOnMoveListener(this)
    }

    override fun onMoveEnd(detector: MoveGestureDetector) = Unit
}