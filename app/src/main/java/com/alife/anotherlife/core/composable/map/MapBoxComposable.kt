package com.alife.anotherlife.core.composable.map

import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.viewinterop.AndroidView
import com.alife.anotherlife.core.composable.lifecycle.OnLifecycle
import com.mapbox.android.gestures.MoveGestureDetector
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.EdgeInsets
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.mapbox.maps.dsl.cameraOptions
import com.mapbox.maps.extension.style.expressions.dsl.generated.interpolate
import com.mapbox.maps.plugin.LocationPuck2D
import com.mapbox.maps.plugin.gestures.OnMoveListener
import com.mapbox.maps.plugin.gestures.gestures
import com.mapbox.maps.plugin.locationcomponent.OnIndicatorBearingChangedListener
import com.mapbox.maps.plugin.locationcomponent.OnIndicatorPositionChangedListener
import com.mapbox.maps.plugin.locationcomponent.location
import com.mapbox.maps.plugin.viewport.data.FollowPuckViewportStateBearing
import com.mapbox.maps.plugin.viewport.data.FollowPuckViewportStateOptions
import com.mapbox.maps.plugin.viewport.data.OverviewViewportStateOptions
import com.mapbox.maps.plugin.viewport.state.FollowPuckViewportState
import com.mapbox.maps.plugin.viewport.state.OverviewViewportState
import com.mapbox.maps.plugin.viewport.viewport
import com.mapbox.maps.viewannotation.viewAnnotationOptions

@Composable
fun MapBoxComposable(modifier: Modifier) {

    OnLifecycle { _, event ->

    }

    val density = LocalDensity.current.density



    AndroidView(factory = { context ->
        MapView(context).apply {
            getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS) {
                cameraOptions { zoom(15.5) }
            }
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
    }, modifier = modifier) { mapView ->
        val viewportPlugin = mapView.viewport

        val viewAnnotation = mapView.viewAnnotationManager.addViewAnnotation(

            // Specify the layout resource id
            resId = R.layout.annotation_view,
            // Set any view annotation options
            options = viewAnnotationOptions {
                geometry(point)
            }
        )
        AnnotationViewBinding.bind(viewAnnotation)

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