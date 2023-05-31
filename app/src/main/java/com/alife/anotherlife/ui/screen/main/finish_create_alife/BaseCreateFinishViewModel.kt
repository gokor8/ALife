package com.alife.anotherlife.ui.screen.main.finish_create_alife

import android.util.Log
import androidx.navigation.NavController
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.core.ui.screen.VMScreenLCE
import com.alife.anotherlife.core.ui.state.lce.StateLCE
import com.alife.anotherlife.core.ui.view_model.BaseViewModelLCE
import com.alife.anotherlife.core.ui.view_model.ViewModelLCE
import com.alife.anotherlife.ui.screen.main.create_alife.state.BaseSnackBarEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.BaseFinishAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishState
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state.FinishPictureEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.model.SnackBarWrapper
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.core.mvi.MVI

interface BaseCreateFinishViewModel<
        REDUCER : BaseCreateFinishReducer<STATE>,
        ACTION : BaseMVIAction<REDUCER>,
        STATE : FinishState<STATE>> : BaseViewModelLCE<REDUCER, ACTION, STATE, FinishEffect> {

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
            >(reducer: REDUCER) : ViewModelLCE<REDUCER, ACTION, STATE, FinishEffect>(reducer),
        BaseCreateFinishViewModel<REDUCER, ACTION, STATE> {

        override suspend fun collectEffect(
            navController: NavController,
            onSnackBarError: (SnackBarWrapper) -> Unit
        ) {
            reducerVM.getEffectCollector().collect { effect ->
                Log.d("catched effect", "$$effect")
                when (effect) {
                    is FinishVideoEffect.UploadVideoError -> onSnackBarError(SnackBarWrapper(R.string.upload_error_video))
                    is FinishPictureEffect.UploadPictureError -> onSnackBarError(SnackBarWrapper(R.string.upload_error_photo))
                    else -> onEffect(navController, effect)
                }
            }
        }
    }
}