package com.alife.anotherlife.core.composable.map

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.mapbox.maps.MapView
import com.mapbox.maps.Style

@Composable
fun MapBoxComposable() {
    AndroidView(factory = { context ->
        MapView(context).apply {
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
    }, modifier = Modifier.fillMaxSize()) {
        it.getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS)
    }
}