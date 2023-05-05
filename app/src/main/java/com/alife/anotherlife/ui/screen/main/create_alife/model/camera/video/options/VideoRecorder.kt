package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options

import androidx.camera.video.Recorder

interface VideoRecorder {

    fun build(): Recorder


    abstract class Abstract(
        private val qualitySelectorStrategy: QualitySelectorStrategy
    ) : VideoRecorder {
        override fun build() = preBuild(Recorder.Builder())
            .setQualitySelector(qualitySelectorStrategy.buildSelector())
            .build()

        open fun preBuild(builder: Recorder.Builder): Recorder.Builder = builder
    }

    class WithAudio(
        qualitySelectorStrategy: QualitySelectorStrategy
    ) : Abstract(qualitySelectorStrategy)

    class WithoutAudio(
        qualitySelectorStrategy: QualitySelectorStrategy
    ) : Abstract(qualitySelectorStrategy)
}