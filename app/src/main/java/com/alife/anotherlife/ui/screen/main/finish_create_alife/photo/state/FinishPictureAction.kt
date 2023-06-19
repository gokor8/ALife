package com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state

import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.BaseFinishAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.BaseFinishMVIAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.BaseFinishPictureReducer

interface FinishPictureAction : BaseFinishMVIAction<BaseFinishPictureReducer> {

    class OnBox(
        finishAction: BaseFinishAction
    ) : FinishPictureAction, BaseFinishMVIAction.OnBox<BaseFinishPictureReducer>(finishAction)
}