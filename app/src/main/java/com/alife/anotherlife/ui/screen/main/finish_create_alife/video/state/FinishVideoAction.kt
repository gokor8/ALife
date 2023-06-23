package com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state

import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.BaseFinishAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.BaseFinishMVIAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.BaseFinishVideoReducer

interface FinishVideoAction : BaseFinishMVIAction<BaseFinishVideoReducer> {

    class OnBox(
        finishAction: BaseFinishAction
    ) : FinishVideoAction, BaseFinishMVIAction.OnBox<BaseFinishVideoReducer>(finishAction)
}