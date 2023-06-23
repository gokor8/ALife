package com.alife.anotherlife.ui.screen.main.finish_create_alife

import android.annotation.SuppressLint
import android.location.Location
import android.util.Log
import com.alife.anotherlife.core.ui.image.ImageExtModel
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_mapper.BaseLocationToEntityLocation
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_mapper.LocationToEntityLocation
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model.BaseLocationModel
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model.EmptyLocationModel
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model.FinishErrorContract
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model.LocationModel
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.BaseFinishAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishState
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.model.GeoImageExtModel
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoEffect
import com.alife.core.mvi.MVI
import com.alife.domain.main.finish_create_alife.BaseFinishLoadUseCase
import com.alife.domain.main.finish_create_alife.BaseVideoFinishLoadUseCase
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

interface BaseCreateFinishReducer<STATE : FinishState<STATE>> :
    BaseVMReducer<STATE, FinishEffect>, FinishErrorContract {

    suspend fun onInit()

    suspend fun onUpload()

    suspend fun onNewLocation(locationModel: BaseLocationModel)

    suspend fun onGps(permissionStatus: PermissionStatus)

    suspend fun onFindLocation(locationTask: Task<Location?>)

    override fun onBackEffect() {
        trySetEffect(FinishEffect.GoBack())
    }

    override fun onRetryEffect() {
        trySetEffect(FinishEffect.Retry())
    }


    abstract class Abstract<STATE : FinishState<STATE>>(
        private val finishLoadUseCase: BaseFinishLoadUseCase,
        private val locationModelMapper: BaseLocationToEntityLocation
    ) : HandlerBaseVMReducer<STATE, FinishEffect>(), BaseCreateFinishReducer<STATE> {

        override suspend fun onNewLocation(locationModel: BaseLocationModel) {
            setState { copyLocation(locationModel) }
        }

        override suspend fun onGps(permissionStatus: PermissionStatus) {
            if (getState().location is LocationModel) {
                setState { copyLocation(EmptyLocationModel()) }
            } else if (permissionStatus is PermissionStatus.Success) {
                setEffect(FinishEffect.RequireGps())
            }
        }

        @SuppressLint("MissingPermission")
        override suspend fun onFindLocation(locationTask: Task<Location?>) {
            setState { copyLocationState(ImageExtModel.Loading()) }
            withContext<Unit>(Dispatchers.IO) {
                locationTask.await()?.apply {
                    setState { copyLocationState(GeoImageExtModel()) }
                    onNewLocation(LocationModel(longitude, latitude))
                }
            }
        }

        override suspend fun onUpload() {
            setState { copyLce(newLceModel = LCELoading) }

            execute {
                Log.e("Aboba", "Some finish error $it")
                trySetEffect(FinishVideoEffect.UploadVideoError())
            }.handleThis(getState()) {
                finishLoadUseCase.upload(locationModelMapper.map(location))
                setEffect(FinishEffect.GoMain())
            }

            setState { copyLce(newLceModel = LCEContent) }
        }
    }
}