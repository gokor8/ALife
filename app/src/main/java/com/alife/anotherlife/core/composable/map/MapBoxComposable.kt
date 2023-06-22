package com.alife.anotherlife.core.composable.map

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.alife.anotherlife.R
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.model.MapElementModel
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.mapbox.maps.dsl.cameraOptions
import com.mapbox.maps.plugin.gestures.addOnMapClickListener
import com.mapbox.maps.plugin.gestures.gestures
import com.mapbox.maps.plugin.locationcomponent.location
import com.mapbox.maps.viewannotation.viewAnnotationOptions


@Composable
fun MapBoxComposable(
    selected: MutableState<MapElementModel> = rememberSaveable { mutableStateOf(MapElementModel.Empty()) },
    mapBoxElements: List<MapElementModel>,
    modifier: Modifier
) {

    var selectedElement by selected

    //var lastPosition by remember {  }

    AndroidView(
        factory = { context ->
            MapView(context).apply {
                getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS) {
                    cameraOptions { zoom(15.5) }
                }
//                getMapboxMap().addOnMapClickListener {
//                    selected.value = MapElementModel.Empty()
//                    true
//                }

                val bearing = AddRemoveLocationChangedListener.Bearing {
                    getMapboxMap().setCamera(CameraOptions.Builder().zoom(15.5).bearing(it).build())
                }

                val position = AddRemoveLocationChangedListener.Position {
                    getMapboxMap().setCamera(CameraOptions.Builder().center(it).build())
                    gestures.focalPoint = getMapboxMap().pixelForCoordinate(it)
                }

                gestures.addOnMoveListener(
                    OnCameraMoveListener(position, bearing, location, gestures)
                )

                location.updateSettings {
                    enabled = true
                    pulsingEnabled = true
                }
                position.addOnIndicatorListener(location)
                bearing.addOnIndicatorListener(location)

                layoutParams = FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
        },
        modifier = modifier
    ) { mapView ->
        mapBoxElements.forEach { element ->
            val isSelected = element == selectedElement

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
                selectedElement = element
            }
        }
    }
}