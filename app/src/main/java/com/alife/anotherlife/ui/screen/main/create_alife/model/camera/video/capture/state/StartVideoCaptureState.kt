package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state

import android.annotation.SuppressLint
import android.content.Context
import androidx.camera.video.FileOutputOptions
import androidx.camera.video.MediaStoreOutputOptions
import androidx.camera.video.Recorder
import androidx.camera.video.VideoCapture
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.callback.CallbackVideoEvent
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.recording.RecordingWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options.BaseFileOutputOptions
import java.util.concurrent.Executor

interface BaseStartVideoCaptureState : BaseVideoCaptureState {
    fun start(contextWrapper: BaseContextMainExecutorWrapper): RecordingWrapper
}

class StartVideoCaptureState(
    private val videoCapture: VideoCapture<Recorder>,
    // TODO переписать, на выполнение в юзкейсе + в репозитории наверное
    private val fileOutputOptions: FileOutputOptions,
    private val callbackVideoEvent: CallbackVideoEvent
) : BaseVideoCaptureState, BaseStartVideoCaptureState {

    @SuppressLint("MissingPermission")
    override fun start(contextWrapper: BaseContextMainExecutorWrapper): RecordingWrapper {
        val recorder = videoCapture.output
            .prepareRecording(contextWrapper.getContext(), fileOutputOptions)
            //.withAudioEnabled()
            .start(contextWrapper.getMainExecutor(), callbackVideoEvent)

        return RecordingWrapper.Default(recorder)
    }
}