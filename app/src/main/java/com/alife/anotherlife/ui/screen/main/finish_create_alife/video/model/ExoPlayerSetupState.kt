package com.alife.anotherlife.ui.screen.main.finish_create_alife.video.model

import androidx.compose.runtime.Stable
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.BaseMediaSource

@Stable
interface ExoPlayerSetupState {

    @androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
    fun setup(exoPlayer: ExoPlayer) {
        exoPlayer.apply {
            videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT
            repeatMode = Player.REPEAT_MODE_ALL
            prepare()
            //playWhenReady = true
        }
    }

    fun afterSetup(exoPlayer: ExoPlayer) = Unit


    abstract class Play : ExoPlayerSetupState {
        override fun afterSetup(exoPlayer: ExoPlayer) {
            exoPlayer.play()
        }
    }

    data class NeedPlay(
        private val mediaSource: BaseMediaSource
    ) : Play() {

        @androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
        override fun setup(exoPlayer: ExoPlayer) {
            exoPlayer.setMediaSource(mediaSource)
            super.setup(exoPlayer)
        }
    }

    data class NeedPlayItem(
        private val mediaItem: MediaItem
    ) : Play() {

        @androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
        override fun setup(exoPlayer: ExoPlayer) {
            exoPlayer.setMediaItem(mediaItem)
            super.setup(exoPlayer)
        }
    }

    object Pause : ExoPlayerSetupState {
        override fun afterSetup(exoPlayer: ExoPlayer) {
            exoPlayer.pause()
        }
    }

    object Empty : ExoPlayerSetupState {
        override fun setup(exoPlayer: ExoPlayer) = Unit
    }
}