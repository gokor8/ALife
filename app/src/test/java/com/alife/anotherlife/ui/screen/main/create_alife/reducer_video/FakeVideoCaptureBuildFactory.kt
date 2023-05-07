package com.alife.anotherlife.ui.screen.main.create_alife.reducer_video

import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options.BaseVideoCaptureBuilder
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.model.BaseVideoCaptureBuilderFactory

class FakeVideoCaptureBuildFactory : BaseVideoCaptureBuilderFactory {
    override fun getBuilder(isAudioEnabled: Boolean): BaseVideoCaptureBuilder {
        return object : BaseVideoCaptureBuilder {}
    }
}