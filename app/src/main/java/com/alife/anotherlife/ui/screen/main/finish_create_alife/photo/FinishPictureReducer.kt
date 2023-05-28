package com.alife.anotherlife.ui.screen.main.finish_create_alife.photo

import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_mapper.BaseFinishExceptionMapper
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_mapper.BasePhotoFinishExceptionMapper
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.mapper.BasePhotoPathEntityToUIPictures
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state.FinishPictureState
import com.alife.domain.main.create_alife.picture.BasePhotoStorageAlifeUseCase
import javax.inject.Inject

class FinishPictureReducer @Inject constructor(
    override val uiStore: UIStore<FinishPictureState, FinishEffect>,
    private val photoStorageAlifeUseCase: BasePhotoStorageAlifeUseCase,
    private val photoPathEntityToUIPictures: BasePhotoPathEntityToUIPictures,
    private val exceptionMapper: BasePhotoFinishExceptionMapper
) : HandlerBaseVMReducer<FinishPictureState, FinishEffect>(), BaseFinishPictureReducer {

    override suspend fun onInit() {
        setState { copy(lceModel = LCELoading) }

        executeThis(getState()) { exception ->
            copy(lceModel = exceptionMapper.map(this@FinishPictureReducer, exception))
        }.handleThis(getState()) {
            val uiPictures = photoPathEntityToUIPictures.map(
                photoStorageAlifeUseCase.getPictures()
            )

            copy(lceModel = LCEContent, uiPicturesModel = uiPictures)
        }.let(::setState)
    }

    override suspend fun onDownload() {
//        execute {
//            Log.e("Aboba", "Some finish error $it")
//            //trySetEffect(FinishVideoEffect.UploadVideoError())
//            //setState { copy(lceModel = LCEError()) } // TODO add backEffect()
//        }.handle {
//            // TODO мб дополнительно из кеша юзл взять, если этот пустой
//            if(getState().videoUrl.isEmpty()) throw IllegalStateException("Empty url")
//
//            // TODO upload and navigate next
//        }
    }
}