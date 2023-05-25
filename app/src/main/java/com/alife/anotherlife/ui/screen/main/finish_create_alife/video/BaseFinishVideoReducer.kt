package com.alife.anotherlife.ui.screen.main.finish_create_alife.video

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoState

interface BaseFinishVideoReducer : BaseVMReducer<FinishVideoState, FinishVideoEffect> {

    suspend fun onInit()
}