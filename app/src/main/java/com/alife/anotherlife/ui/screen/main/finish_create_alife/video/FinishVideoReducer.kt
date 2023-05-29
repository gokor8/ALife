package com.alife.anotherlife.ui.screen.main.finish_create_alife.video

import android.util.Log
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.finish_create_alife.BaseCreateFinishReducer
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_mapper.BaseVideoFinishExceptionMapper
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoState
import com.alife.domain.main.create_alife.video.BaseVideoStorageAlifeUseCase
import com.alife.domain.main.finish_create_alife.BaseVideoFinishLoadUseCase
import java.lang.IllegalStateException
import javax.inject.Inject

class FinishVideoReducer @Inject constructor(
    override val uiStore: UIStore<FinishVideoState, FinishEffect>,
    private val videoStorageAlifeUseCase: BaseVideoStorageAlifeUseCase,
    private val exceptionMapper: BaseVideoFinishExceptionMapper,
    finishLoadUseCase: BaseVideoFinishLoadUseCase
) : BaseCreateFinishReducer.Abstract<FinishVideoState>(finishLoadUseCase), BaseFinishVideoReducer {

    override suspend fun onInit() {
        setState { copy(lceModel = LCELoading) }

        executeThis(getState()) { exception ->
            copy(lceModel = exceptionMapper.map(this@FinishVideoReducer, exception))
        }.handleThis(getState()) {
            val url = videoStorageAlifeUseCase.getVideoStorageEntity().videoUrl

            copy(lceModel = LCEContent, videoUrl = url)
        }.let(::setState)
    }
}