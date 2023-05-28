package com.alife.anotherlife.ui.screen.main.finish_create_alife

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model.FinishErrorContract
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishEffect
import com.alife.core.mvi.MVI

interface BaseCreateFinishReducer<STATE : MVI.State> :
    BaseVMReducer<STATE, FinishEffect>, FinishErrorContract {

    suspend fun onInit()

    suspend fun onDownload()

    override fun onBackEffect() {
        trySetEffect(FinishEffect.GoBack())
    }

    override fun onRetryEffect() {
        trySetEffect(FinishEffect.Retry())
    }


//    abstract class Abstract<STATE : MVI.State>(
//        override val uiStore: UIStore<STATE, FinishEffect>
//    ) : HandlerBaseVMReducer<STATE, FinishEffect>(), BaseCreateFinishReducer<STATE> {
//
//        override fun onBackEffect() {
//            trySetEffect(FinishEffect.GoBack())
//        }
//
//        override fun onRetryEffect() {
//            trySetEffect(FinishEffect.Retry())
//        }
//    }
}