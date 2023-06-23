package com.alife.anotherlife.ui.screen.main.create_alife.reducer_base.test_model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.PictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo.BaseCreateAlifePhotoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.reducer_base.FakeCreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState

class FakeCapturePictureScreenState : PictureScreenState, ScreenState {

    override suspend fun onImageLoaded(
        reducer: BaseCreateAlifePhotoReducer,
        captureWrapper: CookedCaptureWrapper
    ) {
        reducer.setEffect(FakeCreateAlifeEffect.Photo.CreatePhoto())
    }

    @Composable
    override fun Content(viewModel: CreateAlifeViewModel, modifier: Modifier) {}
}