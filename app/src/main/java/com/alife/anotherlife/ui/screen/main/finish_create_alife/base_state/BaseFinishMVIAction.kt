package com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state

import android.util.Log
import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.BaseCreateFinishReducer
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model.LocationModel

interface BaseFinishMVIAction<R : BaseCreateFinishReducer<*>> : BaseMVIAction<R> {

    abstract class OnBox<R : BaseCreateFinishReducer<*>>(
        private val finishAction: BaseFinishAction
    ) : BaseFinishMVIAction<R> {
        override suspend fun onAction(reducer: R) {
            Log.d("Aboba switch", "$finishAction")
            when (finishAction) {
                is BaseFinishAction.Init -> reducer.onInit()
                is BaseFinishAction.Download -> reducer.onUpload()
                is BaseFinishAction.Gps -> reducer.onGps(finishAction.permissionStatus)
                is BaseFinishAction.FindingLocation -> reducer.onFindLocation(finishAction.locationTask)
                is BaseFinishAction.Location -> reducer.onNewLocation(
                    LocationModel(
                        finishAction.longitude,
                        finishAction.latitude
                    )
                )
            }
        }
    }
}