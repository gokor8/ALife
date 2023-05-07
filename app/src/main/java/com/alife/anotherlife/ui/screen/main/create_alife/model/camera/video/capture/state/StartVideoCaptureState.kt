package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state

import android.annotation.SuppressLint
import android.content.Context
import androidx.camera.video.FileOutputOptions
import androidx.camera.video.MediaStoreOutputOptions
import androidx.camera.video.Recorder
import androidx.camera.video.VideoCapture
import androidx.camera.video.VideoRecordEvent
import androidx.core.util.Consumer
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.callback.CallbackVideoEvent
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.recording.RecordingWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options.BaseFileOutputOptions
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options.BaseVideoCaptureBuilder
import java.util.concurrent.Executor

interface BaseStartVideoCaptureState : BaseVideoCaptureState {
    fun start(
        contextWrapper: BaseContextMainExecutorWrapper,
        videoCaptureBuilder: BaseVideoCaptureBuilder,
        fileOutputOptions: BaseFileOutputOptions
    ): RecordingWrapper
}

class StartVideoCaptureState(
    private val videoCapture: VideoCapture<Recorder>,
    private val callbackVideoEvent: Consumer<VideoRecordEvent>
) : BaseVideoCaptureState, BaseStartVideoCaptureState {

    @SuppressLint("MissingPermission")
    override fun start(
        contextWrapper: BaseContextMainExecutorWrapper,
        videoCaptureBuilder: BaseVideoCaptureBuilder,
        fileOutputOptions: BaseFileOutputOptions
    ): RecordingWrapper {
        val recorder = videoCaptureBuilder.build(
            contextWrapper,
            videoCapture.output,
            fileOutputOptions
        ).start(contextWrapper.getMainExecutor(), callbackVideoEvent)

        return RecordingWrapper.Default(recorder)
    }
}