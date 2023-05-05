package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state

import android.annotation.SuppressLint
import android.content.Context
import androidx.camera.video.MediaStoreOutputOptions
import androidx.camera.video.Recorder
import androidx.camera.video.Recording
import androidx.camera.video.VideoCapture
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.callback.CallbackVideoEvent
import java.util.concurrent.Executor

class StartVideoCaptureState(
    videoCapture: VideoCapture<Recorder>,
    private val mediaStoreOutputOptions: MediaStoreOutputOptions,
    private val callbackVideoEvent: CallbackVideoEvent
) : BaseVideoCaptureState.Abstract(videoCapture) {

    @SuppressLint("MissingPermission")
    fun start(context: Context, executor: Executor): Recording {
        return videoCapture.output.prepareRecording(context, mediaStoreOutputOptions)
            //.withAudioEnabled()
            .start(executor, callbackVideoEvent)
    }
}