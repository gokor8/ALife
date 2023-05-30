package com.alife.anotherlife.ui.screen.main.finish_create_alife.video

import android.util.Log
import androidx.navigation.NavController
import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.view_model.ViewModelLCE
import com.alife.anotherlife.ui.screen.main.create_alife.state.BaseSnackBarEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.BaseFinishAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.BaseCreateFinishViewModel
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state.FinishPictureEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FinishVideoViewModel @Inject constructor(
    reducer: BaseFinishVideoReducer
) : ViewModelLCE<BaseFinishVideoReducer, FinishVideoAction, FinishVideoState, FinishEffect>(
    reducer
), BaseCreateFinishViewModel<BaseFinishVideoReducer, FinishVideoAction, FinishVideoState> {

    override fun reduceFinishAction(action: BaseFinishAction) {
        reduce(FinishVideoAction.OnBox(action))
    }

    override suspend fun collectEffect(
        navController: NavController,
        onSnackBarError: (Int) -> Unit
    ) {
        reducerVM.getEffectCollector().collect { effect ->
            Log.d("catched effect", "$$effect")
            if (effect is FinishVideoEffect.UploadVideoError)
                onSnackBarError(R.string.upload_error)
            else if(effect is FinishPictureEffect.UploadPictureError)
                onSnackBarError(R.string.upload_error)
            else
                onEffect(navController, effect)
        }
    }
}