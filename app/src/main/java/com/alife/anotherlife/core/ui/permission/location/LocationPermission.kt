package com.alife.anotherlife.core.ui.permission.location

import android.Manifest
import com.alife.anotherlife.core.ui.dialog.location.FatalLocationDialog
import com.alife.anotherlife.core.ui.dialog.location.LocationDialog
import com.alife.anotherlife.core.ui.permission.FullPermission
import com.alife.anotherlife.core.ui.permission.strategy.BaseStrategyMapper
import com.alife.anotherlife.core.ui.permission.strategy.PermissionStrategy
import javax.inject.Inject

class LocationPermission @Inject constructor() : FullPermission(
    Manifest.permission.ACCESS_FINE_LOCATION,
    permissionStrategy = PermissionStrategy.GoogleRecommend(BaseStrategyMapper.Full()),
    LocationDialog(),
    FatalLocationDialog()
)