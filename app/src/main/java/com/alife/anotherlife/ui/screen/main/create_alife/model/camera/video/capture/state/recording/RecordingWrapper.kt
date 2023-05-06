package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.recording

import androidx.camera.video.Recording

interface RecordingWrapper {

    fun resume()

    fun pause()

    fun stop()


    class Default(private val recording: Recording) : RecordingWrapper {

        override fun resume() {
            recording.resume()
        }

        override fun pause() {
            recording.pause()
        }

        override fun stop() {
            recording.stop()
        }
    }
}