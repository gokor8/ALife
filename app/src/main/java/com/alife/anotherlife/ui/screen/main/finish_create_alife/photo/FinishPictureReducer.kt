package com.alife.anotherlife.ui.screen.main.finish_create_alife.photo

import android.util.Log
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state.FinishPictureEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state.FinishPictureState
import com.alife.domain.main.create_alife.picture.BasePhotoStorageAlifeUseCase
import javax.inject.Inject

class FinishPictureReducer @Inject constructor(
    override val uiStore: UIStore<FinishPictureState, FinishPictureEffect>,
    private val photoStorageAlifeUseCase: BasePhotoStorageAlifeUseCase,
) : HandlerBaseVMReducer<FinishPictureState, FinishPictureEffect>(), BaseFinishPictureReducer {

    override suspend fun onInit() {
        execute<Unit> {
            Log.e("Aboba", "Some finish error $it")
            //setState { copy(lceModel = LCEError()) } // TODO add backEffect()
        }.handle {
            val urls = photoStorageAlifeUseCase.getPictures()

            setState {
                copy(
                    lceModel = LCEContent,
                    firstImageUrl = urls.firstUrl,
                    secondImageUrl = urls.secondUrl
                )
            }
        }
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