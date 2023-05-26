package com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.BaseCreateFinishAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.BaseFinishPictureReducer
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.BaseFinishVideoReducer

interface FinishPictureAction : BaseMVIAction<BaseFinishPictureReducer> {

    class onBox(private val createFinishAction: BaseCreateFinishAction) : FinishPictureAction {
        override suspend fun onAction(reducer: BaseFinishPictureReducer) {
            when (createFinishAction) {
                is BaseCreateFinishAction.Init -> reducer.onInit()
                is BaseCreateFinishAction.Download -> reducer.onDownload()
            }
        }
    }
}