package com.alife.anotherlife.core.composable.map.model

import androidx.compose.runtime.Immutable
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions

@Immutable
data class MapPositionModel(
    val lastPoint: Point = Point.fromLngLat(.0, .0),
    val lastZoom: Double = 15.5,
    val lastBearing: Double = 0.0
) {

    fun getCameraOptions() = CameraOptions.Builder()
        .center(lastPoint)
        .bearing(lastBearing)
        .zoom(lastZoom)
        .build()
}