package com.alife.anotherlife.ui.screen.main.create_alife.reducer_base

import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect

interface FakeCreateAlifeEffect : CreateAlifeEffect {

    interface Photo : FakeCreateAlifeEffect {

        class CreatePhoto : Photo {
            override fun hashCode(): Int = super.hashCode()
            override fun equals(other: Any?) = other is CreatePhoto
        }

        class PermissionGranted : Photo

        class PermissionFatal : Photo
    }

    interface Video : FakeCreateAlifeEffect {

        class StartRecording : Video
        class RecordingAction : Video
        class VideoPrepare : Video

        class ClickSmallVideo : Video

        class PermissionGranted : Video

        class PermissionFatal : Video

        class AudioPermission : Video
    }
}