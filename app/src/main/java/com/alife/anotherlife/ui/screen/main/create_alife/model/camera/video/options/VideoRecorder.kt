package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options

import androidx.camera.video.Recorder

interface VideoRecorder {

    fun build(): Recorder


    class Default : VideoRecorder {
        override fun build() = Recorder.Builder()
            .setQualitySelector(QualitySelectorStrategy.Default().buildSelector())
            .build()

    }
}