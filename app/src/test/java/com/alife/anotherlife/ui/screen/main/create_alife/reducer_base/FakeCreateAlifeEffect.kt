package com.alife.anotherlife.ui.screen.main.create_alife.reducer_base

import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect

interface FakeCreateAlifeEffect : CreateAlifeEffect {

    interface Photo : FakeCreateAlifeEffect {

        class CaptureWrapper : Photo

        class CreatePhoto : Photo {
            override fun hashCode(): Int = super.hashCode()
            override fun equals(other: Any?) = other is CreatePhoto
        }

        class PictureLoading : Photo

        class PermissionGranted : Photo

        class PermissionFatal : Photo

        class PictureFinish : Photo
    }

    interface Video : FakeCreateAlifeEffect {

        class VideoPrepare : Video
        class StartRecording : Video
        class RecordingAction : Video
        class ConfirmStartRecording : Video
        class ConfirmFinalizeRecording : Video

        class VideoLoading : Video

        class ClickSmallVideo : Video

        class PermissionGranted : Video

        class PermissionFatal : Video

        class AudioPermission : Video
    }
}