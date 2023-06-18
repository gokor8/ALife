package com.alife.anotherlife.ui.screen.main.finish_create_alife

import android.util.Log
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.core.ui.permission.location.LocationPermission
import com.alife.anotherlife.core.ui.view_model.BaseViewModelLCE
import com.alife.anotherlife.core.ui.view_model.ViewModelLCE
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.BaseFinishAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishState
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.model.SnackBarWrapper

interface BaseCreateFinishViewModel<
        REDUCER : BaseCreateFinishReducer<STATE>,
        ACTION : BaseMVIAction<REDUCER>,
        STATE : FinishState<STATE>> : BaseViewModelLCE<REDUCER, ACTION, STATE, FinishEffect> {

    val location: LocationPermission

    fun reduceFinishAction(action: BaseFinishAction)

    suspend fun collectEffect(
        navController: NavController,
        onSnackBarError: (SnackBarWrapper) -> Unit
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
        //val cacheDataSourceFactory: CacheDataSourceFactory,
        reducer: REDUCER
    ) : ViewModelLCE<REDUCER, ACTION, STATE, FinishEffect>(reducer),
        BaseCreateFinishViewModel<REDUCER, ACTION, STATE> {

        override val location = LocationPermission()

        override suspend fun collectEffect(
            navController: NavController,
            onSnackBarError: (SnackBarWrapper) -> Unit
        ) {
            reducerVM.getEffectCollector().collect { effect ->
                Log.d("catched effect", "$$effect")
                when (effect) {
                    is SnackBarWrapper -> onSnackBarError(effect)
                    else -> onEffect(navController, effect)
                }
            }
        }
    }
}