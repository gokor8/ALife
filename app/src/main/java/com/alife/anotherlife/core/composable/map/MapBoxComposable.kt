package com.alife.anotherlife.core.composable.map

import android.view.ViewGroup
import android.view.animation.ScaleAnimation
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.load
import com.alife.anotherlife.R
import com.mapbox.android.gestures.MoveGestureDetector
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.mapbox.maps.dsl.cameraOptions
import com.mapbox.maps.plugin.gestures.OnMoveListener
import com.mapbox.maps.plugin.gestures.gestures
import com.mapbox.maps.plugin.locationcomponent.OnIndicatorBearingChangedListener
import com.mapbox.maps.plugin.locationcomponent.OnIndicatorPositionChangedListener
import com.mapbox.maps.plugin.locationcomponent.location
import com.mapbox.maps.viewannotation.viewAnnotationOptions


@Composable
fun MapBoxComposable(modifier: Modifier) {

    val startSize = LocalDensity.current.run { 50.dp.toPx() }
    val finishSize = LocalDensity.current.run { 60.dp.toPx() }

    AndroidView(factory = { context ->
        MapView(context).apply {
            getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS) {
                cameraOptions { zoom(15.5) }
            }
            val viewAnnotation = viewAnnotationManager.addViewAnnotation(
                resId = R.layout.post_map_view,
                options = viewAnnotationOptions {
                    geometry(Point.fromLngLat(39.701504, 47.235714))
                    allowOverlap(true)
                }
            )
            (viewAnnotation as? ImageView)?.also { imageView ->
                imageView.load("http://151.248.123.27:8080/upload/photo_check/96ad8943-2f18-4934-9756-b918c7240d40.jpeg")
                imageView.setOnClickListener {
                    imageView.startAnimation(ResizeAnimation(imageView, finishSize, startSize))
                }
            }

            //viewAnnotationManager.cameraForAnnotations(listOf(viewAnnotation))

            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
    }, modifier = modifier) { mapView ->
        val onIndicatorBearingChangedListener = OnIndicatorBearingChangedListener {
            mapView.getMapboxMap().setCamera(CameraOptions.Builder().zoom(15.5).bearing(it).build())
        }

        val onIndicatorPositionChangedListener = OnIndicatorPositionChangedListener {
            mapView.getMapboxMap().setCamera(CameraOptions.Builder().center(it).build())
            mapView.gestures.focalPoint = mapView.getMapboxMap().pixelForCoordinate(it)
        }

        mapView.gestures.addOnMoveListener(
            object : OnMoveListener {
                override fun onMoveBegin(detector: MoveGestureDetector) {
                    mapView.location
                        .removeOnIndicatorPositionChangedListener(onIndicatorPositionChangedListener)
                    mapView.location
                        .removeOnIndicatorBearingChangedListener(onIndicatorBearingChangedListener)
                    mapView.gestures.removeOnMoveListener(this)
                }

                override fun onMove(detector: MoveGestureDetector): Boolean {
                    return false
                }

                override fun onMoveEnd(detector: MoveGestureDetector) {}
            }
        )

        val locationComponentPlugin = mapView.location
        locationComponentPlugin.updateSettings {
            enabled = true
            pulsingEnabled = true
        }
        locationComponentPlugin.addOnIndicatorPositionChangedListener(
            onIndicatorPositionChangedListener
        )
        locationComponentPlugin.addOnIndicatorBearingChangedListener(
            onIndicatorBearingChangedListener
        )
    }
}