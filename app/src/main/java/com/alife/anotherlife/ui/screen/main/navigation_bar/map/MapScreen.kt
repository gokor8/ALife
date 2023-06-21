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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.launch

class MapScreen(
    private val innerPadding: PaddingValues,
    override val navController: NavController
) : VMScreenLCE<MapViewModel>() {

    @Composable
    override fun setupViewModel(): MapViewModel = hiltViewModel()

    override suspend fun onInit() {
        viewModel.reduce(MapAction.Init())
    }

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

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun SafeContent(modifier: Modifier) {
        val uiPosts = viewModel.getUIState().mapPosts
        val coroutineScope = rememberCoroutineScope()
        val selected = remember { mutableStateOf<MapElementModel>(MapElementModel.Empty()) }
        val bottomSheetState = rememberModalBottomSheetState()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            MapBoxComposable(
                selected = selected,
                mapBoxElements = uiPosts,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(PaddingValues(bottom = innerPadding.calculateBottomPadding() - 26.dp))
            )

            LaunchedEffect(selected.value) {
                if (selected.value !is MapElementModel.Empty)
                    bottomSheetState.show()
                else
                    bottomSheetState.hide()
            }

            if (bottomSheetState.isVisible) {
                ModalBottomSheet(
                    sheetState = bottomSheetState,
                    onDismissRequest = {
                        selected.value = MapElementModel.Empty()
                        coroutineScope.launch { bottomSheetState.hide() }
                    }
                ) {
                    selected.value.BottomBarContent {

                    }
                }
            }

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