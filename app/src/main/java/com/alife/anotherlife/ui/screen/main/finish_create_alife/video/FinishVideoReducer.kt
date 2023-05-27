package com.alife.anotherlife.ui.screen.main.finish_create_alife.video

import android.util.Log
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.core.ui.state_collector.EffectCollector
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_mapper.BaseFinishExceptionMapper
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_mapper.BaseVideoFinishExceptionMapper
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.mapper.BaseVideoEntityToUrl
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoState
import com.alife.data.repository.main.create_alife.NoFileException
import com.alife.domain.main.create_alife.video.BaseVideoStorageAlifeUseCase
import kotlinx.coroutines.delay
import java.lang.IllegalStateException
import javax.inject.Inject

class FinishVideoReducer @Inject constructor(
    override val uiStore: UIStore<FinishVideoState, FinishEffect>,
    private val videoStorageAlifeUseCase: BaseVideoStorageAlifeUseCase,
    private val videoToUrlMapper: BaseVideoEntityToUrl,
    private val exceptionMapper: BaseVideoFinishExceptionMapper
) : HandlerBaseVMReducer<FinishVideoState, FinishEffect>(), BaseFinishVideoReducer {

    override suspend fun onInit() {
        setState { copy(lceModel = LCELoading) }
        delay(1000L)

        executeThis(getState()) { exception ->
            copy(lceModel = exceptionMapper.map(this@FinishVideoReducer, exception))
        }.handleThis(getState()) {
            val url = videoToUrlMapper.map(
                videoStorageAlifeUseCase.getVideoStorageEntity()
            )

            copy(lceModel = LCEContent, videoUrl = url)
        }.let(::setState)
    }

    override suspend fun onDownload() {
        execute {
            Log.e("Aboba", "Some finish error $it")
            trySetEffect(FinishVideoEffect.UploadVideoError())
            //setState { copy(lceModel = LCEError()) } // TODO add backEffect()
        }.handle {
            // TODO мб дополнительно из кеша юзл взять, если этот пустой
            if (getState().videoUrl.isEmpty()) throw IllegalStateException("Empty url")

            // TODO upload and navigate next
        }
    }


}