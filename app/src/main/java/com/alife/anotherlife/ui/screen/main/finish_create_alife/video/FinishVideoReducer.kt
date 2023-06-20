package com.alife.anotherlife.ui.screen.main.finish_create_alife.video

import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.finish_create_alife.BaseCreateFinishReducer
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_mapper.BaseLocationToEntityLocation
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_mapper.BaseVideoFinishExceptionMapper
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoState
import com.alife.domain.main.create_alife.video.BaseVideoStorageAlifeUseCase
import com.alife.domain.main.finish_create_alife.BaseVideoFinishLoadUseCase
import javax.inject.Inject

class FinishVideoReducer @Inject constructor(
    override val uiStore: UIStore<FinishVideoState, FinishEffect>,
    private val videoStorageAlifeUseCase: BaseVideoStorageAlifeUseCase,
    private val exceptionMapper: BaseVideoFinishExceptionMapper,
    locationModelMapper: BaseLocationToEntityLocation,
    finishLoadUseCase: BaseVideoFinishLoadUseCase
) : BaseCreateFinishReducer.Abstract<FinishVideoState>(finishLoadUseCase, locationModelMapper),
    BaseFinishVideoReducer {

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