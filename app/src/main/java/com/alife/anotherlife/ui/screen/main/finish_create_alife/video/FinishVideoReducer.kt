package com.alife.anotherlife.ui.screen.main.finish_create_alife.video

import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.mapper.BaseVideoEntityToUrl
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoState
import com.alife.domain.main.create_alife.video.BaseVideoStorageAlifeUseCase
import javax.inject.Inject

class FinishVideoReducer @Inject constructor(
    override val uiStore: UIStore<FinishVideoState, FinishVideoEffect>,
    private val videoStorageAlifeUseCase: BaseVideoStorageAlifeUseCase,
    private val videoToUrlMapper: BaseVideoEntityToUrl
) : HandlerBaseVMReducer<FinishVideoState, FinishVideoEffect>(), BaseFinishVideoReducer {

    override suspend fun onInit() {
        execute {
            //setState { copy(lceModel = LCEError()) } // TODO add backEffect()
        }.handle {
            val url = videoToUrlMapper.map(
                videoStorageAlifeUseCase.getVideoStorageEntity()
            )

            setState { copy(lceModel = LCEContent, videoUrl = url) }
        }
    }

    fun backEffect() {
        trySetEffect(FinishVideoEffect.GoBack())
    }
}