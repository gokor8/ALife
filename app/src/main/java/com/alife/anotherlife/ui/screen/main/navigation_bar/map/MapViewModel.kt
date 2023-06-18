package com.alife.anotherlife.ui.screen.main.navigation_bar.map

import android.util.Log
import com.alife.anotherlife.core.ui.permission.PermissionBoxer
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.permission.location.LocationPermission
import com.alife.anotherlife.core.ui.permission.location.MomentaryLocationPermission
import com.alife.anotherlife.core.ui.view_model.ViewModelLCE
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.mapper.LceErrorMapMapper
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.state.MapAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.state.MapEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.state.MapState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    reducer: BaseMapReducer
) : ViewModelLCE<BaseMapReducer, MapAction, MapState, MapEffect>(reducer), PermissionBoxer {

    val lceErrorMapMapper = LceErrorMapMapper()
   // val momentaryLocationPermission = MomentaryLocationPermission()
    val locationPermission = LocationPermission()

    override fun reduceBox(permissionStatus: PermissionStatus) {
        Log.d("Full Dialog in ViewModel", "$permissionStatus")
        when(permissionStatus) {
            is PermissionStatus.Success -> reduce(MapAction.MapPermissionGranted())
            is PermissionStatus.Fatal -> reduce(MapAction.MapPermissionFatal())
        }
    }
}