package com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state

import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.core.mvi.MVI
import com.google.android.gms.tasks.Task

interface BaseFinishAction : MVI.Action {

    class Init : BaseFinishAction

    class Gps(val permissionStatus: PermissionStatus) : BaseFinishAction

    class FindingLocation(val locationTask: Task<android.location.Location?>) : BaseFinishAction

    class Location(val longitude: Double, val latitude: Double) : BaseFinishAction

    class Download : BaseFinishAction
}