package com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.BaseFinishVideoReducer

interface FinishVideoAction : BaseMVIAction<BaseFinishVideoReducer> {

    class OnInit : FinishVideoAction {
        override suspend fun onAction(reducer: BaseFinishVideoReducer) {
            reducer.onInit()
        }
    }
}