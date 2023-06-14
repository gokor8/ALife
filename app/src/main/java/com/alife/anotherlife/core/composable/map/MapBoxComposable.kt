package com.alife.anotherlife.core.composable.map

import android.view.ViewGroup
import android.view.animation.ScaleAnimation
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.load
import com.alife.anotherlife.R
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.model.MapElementModel
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
fun MapBoxComposable(
    mapBoxElements: List<MapElementModel>,
    modifier: Modifier
) {

    var lastSelectedElement by remember { mutableStateOf<MapElementModel>(MapElementModel.Empty()) }

    AndroidView(factory = { context ->
        MapView(context).apply {
            getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS) {
                cameraOptions { zoom(15.5) }
            }

            mapBoxElements.forEach { element ->
                val isSelected = element == lastSelectedElement

                val viewAnnotation = viewAnnotationManager.addViewAnnotation(
                    resId = R.layout.post_map_view,
                    options = viewAnnotationOptions {
                        geometry(element.point)
                        allowOverlap(isSelected)
                    }
                )

                element.onBind(viewAnnotation, isSelected) {
                    lastSelectedElement = element
                }
            }

            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
    }, modifier = modifier) { mapView ->
        //viewAnnotationManager.cameraForAnnotations(listOf(viewAnnotation))

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

                override fun onMoveEnd(detector: MoveGestureDetector) = Unit
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