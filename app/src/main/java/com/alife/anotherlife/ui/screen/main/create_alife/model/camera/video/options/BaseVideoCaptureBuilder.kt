package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options

import android.annotation.SuppressLint
import androidx.camera.video.PendingRecording
import androidx.camera.video.Recorder
import com.alife.anotherlife.ui.screen.main.create_alife.addons.CustomContextWrapper

interface BaseVideoCaptureBuilder {

    fun build(
        context: CustomContextWrapper,
        recorder: Recorder,
        outputOptions: BaseFileOutputOptions
    ): PendingRecording = recorder.prepareRecording(context.getContext(), outputOptions.options())


    @SuppressLint("MissingPermission")
    class WithAudio : BaseVideoCaptureBuilder {

        override fun build(
            context: CustomContextWrapper,
            recorder: Recorder,
            outputOptions: BaseFileOutputOptions
        ) = super.build(context, recorder, outputOptions).withAudioEnabled()
    }

    @SuppressLint("MissingPermission")
    class WithoutAudio : BaseVideoCaptureBuilder {

        override fun build(
            context: CustomContextWrapper,
            recorder: Recorder,
            outputOptions: BaseFileOutputOptions
        ) = super.build(context, recorder, outputOptions)
    }
}