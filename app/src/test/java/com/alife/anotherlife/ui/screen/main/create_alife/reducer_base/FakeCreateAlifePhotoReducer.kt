package com.alife.anotherlife.ui.screen.main.create_alife.reducer_base

import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BasePictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.PictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo.BaseCreateAlifePhotoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import kotlinx.coroutines.CoroutineScope

class FakeCreateAlifePhotoReducer(
    override val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>
) : AbstractVMReducer<CreateAlifeState, CreateAlifeEffect>(), BaseCreateAlifePhotoReducer {

    override fun onCaptureWrapper(captureWrapper: CookedCaptureWrapper) {
        uiStore.trySetEffect(FakeCreateAlifeEffect.Photo.CaptureWrapper())
    }

    override suspend fun onCreatePhoto(
        viewModelScope: CoroutineScope,
        screenState: PictureScreenState,
        captureWrapper: CookedCaptureWrapper,
        contextWrapper: BaseContextMainExecutorWrapper
    ) {
        uiStore.setEffect(FakeCreateAlifeEffect.Photo.CreatePhoto())
    }

    override suspend fun onPictureLoading() {
        uiStore.setEffect(FakeCreateAlifeEffect.Photo.PictureLoading())
    }

    override suspend fun onFinish() {
        uiStore.setEffect(FakeCreateAlifeEffect.Photo.PictureFinish())
    }

    override suspend fun onPermissionGranted(screenState: BasePictureScreenState) {
        uiStore.setEffect(FakeCreateAlifeEffect.Photo.PermissionGranted())
    }

    override suspend fun onPermissionFatal() {
        uiStore.setEffect(FakeCreateAlifeEffect.Photo.PermissionFatal())
    }
}