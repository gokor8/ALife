package com.alife.anotherlife.ui.screen.main.finish_create_alife.video

import android.util.Log
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.mapper.BaseVideoEntityToUrl
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoState
import com.alife.domain.main.create_alife.video.BaseVideoStorageAlifeUseCase
import java.lang.IllegalStateException
import javax.inject.Inject

class FinishVideoReducer @Inject constructor(
    override val uiStore: UIStore<FinishVideoState, FinishVideoEffect>,
    private val videoStorageAlifeUseCase: BaseVideoStorageAlifeUseCase,
    private val videoToUrlMapper: BaseVideoEntityToUrl
) : HandlerBaseVMReducer<FinishVideoState, FinishVideoEffect>(), BaseFinishVideoReducer {

    override suspend fun onInit() {
        execute<Unit> {
            Log.e("Aboba", "Some finish error $it")
            //setState { copy(lceModel = LCEError()) } // TODO add backEffect()
        }.handle {
            val url = videoToUrlMapper.map(
                videoStorageAlifeUseCase.getVideoStorageEntity()
            )

            setState { copy(lceModel = LCEContent, videoUrl = url) }
        }
    }

    override suspend fun onDownload() {
        execute {
            Log.e("Aboba", "Some finish error $it")
            trySetEffect(FinishVideoEffect.UploadVideoError())
            //setState { copy(lceModel = LCEError()) } // TODO add backEffect()
        }.handle {
            // TODO мб дополнительно из кеша юзл взять, если этот пустой
            if(getState().videoUrl.isEmpty()) throw IllegalStateException("Empty url")

            // TODO upload and navigate next
        }
    }

    fun backEffect() {
        trySetEffect(FinishVideoEffect.GoBack())
    }
}