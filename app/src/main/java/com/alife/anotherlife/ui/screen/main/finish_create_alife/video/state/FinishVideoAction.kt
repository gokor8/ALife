package com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.BaseFinishAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.BaseFinishVideoReducer

interface FinishVideoAction : BaseMVIAction<BaseFinishVideoReducer> {

    class OnBox(private val createFinishAction: BaseFinishAction) : FinishVideoAction{
        override suspend fun onAction(reducer: BaseFinishVideoReducer) {
            when(createFinishAction) {
                is BaseFinishAction.Init -> reducer.onInit()
                is BaseFinishAction.Download -> reducer.onDownload()
            }
        }
    }
}