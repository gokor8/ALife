package com.alife.anotherlife.ui.screen.main.finish_create_alife

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.core.mvi.MVI

interface BaseCreateFinishReducer<STATE : MVI.State, EFFECT : MVI.Effect> :
    BaseVMReducer<STATE, EFFECT> {

    suspend fun onInit()

    suspend fun onDownload()
}