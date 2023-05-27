package com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state

import com.alife.core.mvi.MVI

interface BaseFinishAction : MVI.Action {

    class Init : BaseFinishAction

    class Download : BaseFinishAction
}