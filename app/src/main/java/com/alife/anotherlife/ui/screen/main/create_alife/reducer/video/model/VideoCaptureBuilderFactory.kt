package com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.model

import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options.BaseVideoCaptureBuilder
import javax.inject.Inject

class VideoCaptureBuilderFactory @Inject constructor() : BaseVideoCaptureBuilderFactory {

    override fun getBuilder(isAudioEnabled: Boolean): BaseVideoCaptureBuilder {
        return if (isAudioEnabled)
            BaseVideoCaptureBuilder.WithAudio()
        else
            BaseVideoCaptureBuilder.WithoutAudio()
    }
}