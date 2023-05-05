package com.alife.anotherlife.ui.screen.main.create_alife.reducer_base.test_model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BaseCameraPictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState

class FakeCapturePictureScreenState : BaseCameraPictureScreenState, ScreenState {
    override suspend fun onImageLoaded(
        reducer: AbstractVMReducer<CreateAlifeState, CreateAlifeEffect>
    ) {}

    @Composable
    override fun Content(viewModel: CreateAlifeViewModel, modifier: Modifier) {}
}