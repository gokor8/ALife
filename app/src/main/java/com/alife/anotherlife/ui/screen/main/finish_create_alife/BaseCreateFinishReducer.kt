package com.alife.anotherlife.ui.screen.main.finish_create_alife

import android.util.Log
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model.BaseLocationModel
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model.EmptyLocationModel
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model.FinishErrorContract
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model.LocationModel
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishState
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoEffect
import com.alife.core.mvi.MVI
import com.alife.domain.main.finish_create_alife.BaseFinishLoadUseCase
import com.alife.domain.main.finish_create_alife.BaseVideoFinishLoadUseCase

interface BaseCreateFinishReducer<STATE : FinishState<STATE>> :
    BaseVMReducer<STATE, FinishEffect>, FinishErrorContract {

    suspend fun onInit()

    suspend fun onDownload()

    suspend fun onNewLocation(locationModel: BaseLocationModel)

    suspend fun onGps(permissionStatus: PermissionStatus)

    override fun onBackEffect() {
        trySetEffect(FinishEffect.GoBack())
    }

    override fun onRetryEffect() {
        trySetEffect(FinishEffect.Retry())
    }


    abstract class Abstract<STATE : FinishState<STATE>>(
        private val finishLoadUseCase: BaseFinishLoadUseCase
    ) : HandlerBaseVMReducer<STATE, FinishEffect>(), BaseCreateFinishReducer<STATE> {

        override suspend fun onNewLocation(locationModel: BaseLocationModel) {
            setState { copyLocation(locationModel) }
        }

        override suspend fun onGps(permissionStatus: PermissionStatus) {
            if(getState().location is LocationModel) {
                Log.d("Aboba switch", "copy empty")
                setState { copyLocation(EmptyLocationModel()) }
            } else if(permissionStatus is PermissionStatus.Success) {
                Log.d("Aboba switch", "require gps")
                setEffect(FinishEffect.RequireGps())
            }
        }

        override suspend fun onDownload() {
            setState { copyLce(newLceModel = LCELoading) }

            execute {
                Log.e("Aboba", "Some finish error $it")
                trySetEffect(FinishVideoEffect.UploadVideoError())
                // TODO если 500 ошибка, то говорить что чел уже выкладывал сегодня пост
                //setState { copy(lceModel = LCEError()) } // TODO add backEffect()
            }.handle {
                finishLoadUseCase.upload()

                setEffect(FinishEffect.GoMain())
                // TODO upload and navigate next
            }

            setState { copyLce(newLceModel = LCEContent) }
        }
    }
}