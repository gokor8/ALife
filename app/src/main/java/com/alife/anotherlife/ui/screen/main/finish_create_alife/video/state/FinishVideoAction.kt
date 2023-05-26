package com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.BaseCreateFinishAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.BaseFinishPictureReducer
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.BaseFinishVideoReducer

interface FinishVideoAction : BaseMVIAction<BaseFinishVideoReducer> {

    class onBox(private val createFinishAction: BaseCreateFinishAction) : FinishVideoAction{
        override suspend fun onAction(reducer: BaseFinishVideoReducer) {
            when(createFinishAction) {
                is BaseCreateFinishAction.Init -> reducer.onInit()
                is BaseCreateFinishAction.Download -> reducer.onDownload()
            }
        }
    }
}