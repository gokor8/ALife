package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.callback

import androidx.camera.video.VideoRecordEvent
import androidx.core.util.Consumer
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction

class CallbackVideoEvent(
    private val viewModel: CreateAlifeViewModel
) : Consumer<VideoRecordEvent> {
    override fun accept(t: VideoRecordEvent) {
        viewModel.reduce(CreateAlifeAction.VideoRecordEventAction(t))
    }
}