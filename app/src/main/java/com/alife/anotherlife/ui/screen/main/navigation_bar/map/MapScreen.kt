package com.alife.anotherlife.ui.screen.main.navigation_bar.map

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.map.MapBoxComposable
import com.alife.anotherlife.core.ui.permission.location.LocationPermission
import com.alife.anotherlife.core.ui.permission.location.MomentaryLocationPermission
import com.alife.anotherlife.core.ui.screen.DefaultScreen
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.core.ui.screen.VMScreenLCE
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.mapper.LceErrorMapMapper
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.state.MapAction
import com.google.accompanist.permissions.ExperimentalPermissionsApi

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

        LaunchedEffect(key1 = true) {
            Log.d("Aboba", "${this.javaClass.name}")
            permission.launchPermissionRequest()
        }
    }

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun LceStateMap(lceModel: LCEModel, modifier: Modifier) {
        val permission = viewModel.locationPermission.requirePermission(viewModel)

        viewModel.lceErrorMapMapper.Map(lceModel, modifier) {
            permission.launchPermissionRequest()
            viewModel.reduce(MapAction.Init())
        }
    }

    @Composable
    override fun SafeContent(modifier: Modifier) {
        MapBoxComposable(
            Modifier
                .fillMaxSize()
                .padding(PaddingValues(bottom = innerPadding.calculateBottomPadding() - 26.dp)))
    }
}