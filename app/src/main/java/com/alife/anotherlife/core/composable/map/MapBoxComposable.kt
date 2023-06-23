package com.alife.anotherlife.core.composable.map

import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.doOnAttach
import androidx.core.view.doOnDetach
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.map.listeners.AddRemoveLocationChangedListener
import com.alife.anotherlife.core.composable.map.listeners.AddRemoveMoveLocationMapListener
import com.alife.anotherlife.core.composable.map.listeners.AddRemoveMoveMapListener
import com.alife.anotherlife.core.composable.map.listeners.AddRemoveOnCameraChangeListener
import com.alife.anotherlife.core.composable.map.listeners.AddRemoveZoomMapListener
import com.alife.anotherlife.core.composable.map.listeners.MoveMapUserListener
import com.alife.anotherlife.core.composable.map.listeners.OnCameraMoveListener
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.model.MapElementModel
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.mapbox.maps.dsl.cameraOptions
import com.mapbox.maps.extension.style.expressions.dsl.generated.zoom
import com.mapbox.maps.plugin.animation.camera
import com.mapbox.maps.plugin.gestures.gestures
import com.mapbox.maps.plugin.locationcomponent.location
import com.mapbox.maps.viewannotation.viewAnnotationOptions

@Composable
fun MapBoxComposable(
    mapBoxElements: List<MapElementModel>,
    modifier: Modifier = Modifier,
    selected: MapElementModel = MapElementModel.Empty(),
    onSelected: (MapElementModel) -> Unit
) {

    var lastPoint by rememberSaveable { mutableStateOf(Point.fromLngLat(.0, .0)) }
    var lastZoom by rememberSaveable { mutableStateOf(15.5) }
    var lastBearing by rememberSaveable { mutableStateOf(0.0) }

    AndroidView(
        factory = { context ->
            MapView(context).apply {
                getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS) {
                    cameraOptions {
                        zoom(15.5)
                    }
                }
//                getMapboxMap().addOnMapClickListener {
//                    selected.value = MapElementModel.Empty()
//                    true
//                }

                val cameraChangeListener = AddRemoveOnCameraChangeListener {
                    val cameraState = getMapboxMap().cameraState
                    lastZoom = cameraState.zoom
                    lastPoint = cameraState.center
                    lastBearing = cameraState.bearing
                }

                val bearing = AddRemoveLocationChangedListener.Bearing { bearing ->
                    lastBearing = bearing
                }

                val position = AddRemoveLocationChangedListener.Position { point ->
                    lastPoint = point
                    gestures.focalPoint = getMapboxMap().pixelForCoordinate(point)
                }

                val locationMoveListener = AddRemoveMoveLocationMapListener(
                    OnCameraMoveListener(position, bearing, location, gestures)
                )

                location.updateSettings {
                    enabled = true
                    pulsingEnabled = true
                }

                layoutParams = FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
                )

                doOnAttach {
                    cameraChangeListener.addListener(getMapboxMap())
                    if (lastPoint.latitude() == .0 || lastPoint.longitude() == .0) {
                        locationMoveListener.addListener(gestures)
                        bearing.addListener(location)
                        position.addListener(location)
                    }
                }

                doOnDetach {
                    cameraChangeListener.removeListener(getMapboxMap())
                    locationMoveListener.removeListener(gestures)
                    bearing.removeListener(location)
                    position.removeListener(location)
                }
            }
        },
        modifier = modifier
    ) { mapView ->

        mapView.getMapboxMap().setCamera(
            CameraOptions.Builder()
                .center(lastPoint)
                .bearing(lastBearing)
                .zoom(lastZoom)
                .build()
        )

        mapBoxElements.forEach { element ->
            val isSelected = element == selected

            val createdView =
                mapView.viewAnnotationManager.annotations.firstNotNullOfOrNull {
                    if (it.value.geometry == element.point) it.key else null
                } ?: mapView.viewAnnotationManager.addViewAnnotation(
                    resId = R.layout.post_map_view,
                    options = viewAnnotationOptions {
                        geometry(element.point)
                        allowOverlap(isSelected)
                    }
                )

            element.onBind(createdView, isSelected) {
                onSelected(element)
            }
        }
    }
}