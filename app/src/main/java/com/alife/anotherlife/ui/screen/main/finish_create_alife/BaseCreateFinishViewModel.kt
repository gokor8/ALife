package com.alife.anotherlife.ui.screen.main.finish_create_alife

import android.util.Log
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.core.ui.permission.PermissionBoxer
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.permission.location.LocationPermission
import com.alife.anotherlife.core.ui.view_model.BaseViewModelLCE
import com.alife.anotherlife.core.ui.view_model.ViewModelLCE
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.BaseFinishAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishState
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.model.SnackBarWrapper
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationToken
import com.google.android.gms.tasks.CancellationTokenSource

interface BaseCreateFinishViewModel<
        REDUCER : BaseCreateFinishReducer<STATE>,
        ACTION : BaseMVIAction<REDUCER>,
        STATE : FinishState<STATE>> : BaseViewModelLCE<REDUCER, ACTION, STATE, FinishEffect>,
    PermissionBoxer {

    val location: LocationPermission

    fun reduceFinishAction(action: BaseFinishAction)

    suspend fun collectEffect(
        navController: NavController,
        onSnackBarError: (SnackBarWrapper) -> Unit,
        onLocation: (Int, CancellationToken) -> Unit
    )

    override suspend fun onEffect(navController: NavController, effect: FinishEffect) {
        if (effect is FinishEffect.Retry)
            reduceFinishAction(BaseFinishAction.Init())
        else
            super.onEffect(navController, effect)
    }


    abstract class Abstract<
            REDUCER : BaseCreateFinishReducer<STATE>,
            ACTION : BaseMVIAction<REDUCER>,
            STATE : FinishState<STATE>
            >(
        reducer: REDUCER
    ) : ViewModelLCE<REDUCER, ACTION, STATE, FinishEffect>(reducer),
        BaseCreateFinishViewModel<REDUCER, ACTION, STATE> {

        override val location = LocationPermission()

        override fun reduceBox(permissionStatus: PermissionStatus) {
            reduceFinishAction(BaseFinishAction.Gps(permissionStatus))
        }

        override suspend fun collectEffect(
            navController: NavController,
            onSnackBarError: (SnackBarWrapper) -> Unit,
            onLocation: (Int, CancellationToken) -> Unit
        ) {
            reducerVM.getEffectCollector().collect { effect ->
                when (effect) {
                    is SnackBarWrapper -> onSnackBarError(effect)
                    is FinishEffect.RequireGps -> onLocation(
                        Priority.PRIORITY_HIGH_ACCURACY,
                        CancellationTokenSource().token
                    )
                    else -> onEffect(navController, effect)
                }
            }
        }
    }
}