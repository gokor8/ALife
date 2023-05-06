package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.callback

import android.util.Log
import androidx.camera.video.VideoRecordEvent
import androidx.core.util.Consumer
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.CreateAlifeVideoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import javax.inject.Inject

class CallbackVideoEvent(
    private val reducer: CreateAlifeVideoReducer
) : Consumer<VideoRecordEvent> {
    override fun accept(t: VideoRecordEvent) {
        Log.e("Aboba", t.toString())
        //viewModel.reduce(CreateAlifeAction.VideoRecordEventAction(t))
    }
}