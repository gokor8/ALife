package com.alife.anotherlife.ui.screen.main.navigation_bar.map

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.brush.verticalPrimaryGradient
import com.alife.anotherlife.core.composable.map.MapBoxComposable
import com.alife.anotherlife.core.ui.screen.VMScreenLCE
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.model.MapElementModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.state.MapAction
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.mapbox.geojson.Point

class MapScreen(
    private val innerPadding: PaddingValues,
    override val navController: NavController
) : VMScreenLCE<MapViewModel>() {

    @Composable
    override fun setupViewModel(): MapViewModel = hiltViewModel()

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun OnInitComposable() {
        val permission = viewModel.locationPermission.requirePermission(viewModel)

        LaunchedEffect(Unit) {
            permission.launchPermissionRequest()
        }
    }

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun LceStateMap(lceModel: LCEModel, modifier: Modifier) {
        val permission = viewModel.locationPermission.requirePermission(viewModel)

        viewModel.lceErrorMapMapper.Map(lceModel, modifier) {
            Log.d("Full Dialog", "require permission")
            permission.launchPermissionRequest()
            viewModel.reduce(MapAction.Init())
        }
    }

    @Composable
    override fun SafeContent(modifier: Modifier) {
        Box(modifier = Modifier.fillMaxSize().statusBarsPadding()) {
            MapBoxComposable(
                mapBoxElements = listOf(
                    MapElementModel.Image(
                        Point.fromLngLat(40.701604, 47.235714),
                        "http://151.248.123.27:8080/upload/photo_check/96ad8943-2f18-4934-9756-b918c7240d40.jpeg"
                    ),
                    MapElementModel.Image(
                        Point.fromLngLat(39.701504, 47.235714),
                        "http://151.248.123.27:8080/upload/photo_check/96ad8943-2f18-4934-9756-b918c7240d40.jpeg"
                    ),
                    MapElementModel.Image(
                        Point.fromLngLat(39.901504, 47.235714),
                        "http://151.248.123.27:8080/upload/photo_check/96ad8943-2f18-4934-9756-b918c7240d40.jpeg"
                    ),
                    MapElementModel.Image(
                        Point.fromLngLat(40.901504, 47.235714),
                        "http://151.248.123.27:8080/upload/photo_check/96ad8943-2f18-4934-9756-b918c7240d40.jpeg"
                    )
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(PaddingValues(bottom = innerPadding.calculateBottomPadding() - 26.dp))
            )

            val gradient = verticalPrimaryGradient()
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .align(Alignment.TopCenter)
            ) { drawRect(brush = gradient, size = size) }
        }
    }
}