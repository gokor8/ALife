package com.alife.anotherlife.ui.screen.main.create_alife.reducer_base

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BaseCameraPictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BaseInvertPictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo.BaseCreateAlifePhotoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import java.util.concurrent.Executor

class FakeCreateAlifePhotoReducer(
    private val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>
) : BaseCreateAlifePhotoReducer {

    override suspend fun onCreatePhoto(
        screenState: BaseInvertPictureScreenState,
        contextWrapper: BaseContextMainExecutorWrapper
    ) {
        uiStore.setEffect(FakeCreateAlifeEffect.Photo.CreatePhoto())
    }

    override suspend fun onPermissionGranted(newScreenState: ScreenState) {
        uiStore.setEffect(FakeCreateAlifeEffect.Photo.CreatePhoto())
    }

    override suspend fun onPermissionFatal() {
        uiStore.setEffect(FakeCreateAlifeEffect.Photo.CreatePhoto())
    }
}