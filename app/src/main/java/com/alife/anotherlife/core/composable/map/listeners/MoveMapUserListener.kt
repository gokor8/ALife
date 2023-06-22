package com.alife.anotherlife.core.composable.map.listeners

import com.mapbox.android.gestures.MoveGestureDetector
import com.mapbox.maps.plugin.gestures.OnMoveListener

class MoveMapUserListener(private val onMoveEnd: () -> Unit) : OnMoveListener {

    override fun onMove(detector: MoveGestureDetector) = false

    override fun onMoveBegin(detector: MoveGestureDetector) = Unit

    override fun onMoveEnd(detector: MoveGestureDetector) {
        onMoveEnd()
    }
}