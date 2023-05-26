package com.alife.anotherlife.ui.screen.main.finish_create_alife

import com.alife.core.mvi.MVI

interface BaseCreateFinishAction : MVI.Action {

    class Init : BaseCreateFinishAction

    class Download : BaseCreateFinishAction
}