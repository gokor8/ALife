package com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.BaseFinishAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.BaseFinishPictureReducer

interface FinishPictureAction : BaseMVIAction<BaseFinishPictureReducer> {

    class OnBox(private val createFinishAction: BaseFinishAction) : FinishPictureAction {
        override suspend fun onAction(reducer: BaseFinishPictureReducer) {
            when (createFinishAction) {
                is BaseFinishAction.Init -> reducer.onInit()
                is BaseFinishAction.Download -> reducer.onDownload()
            }
        }
    }
}