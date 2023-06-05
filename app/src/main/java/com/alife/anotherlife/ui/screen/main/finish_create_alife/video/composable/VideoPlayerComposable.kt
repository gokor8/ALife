package com.alife.anotherlife.ui.screen.main.finish_create_alife.video.composable

import android.net.Uri
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import com.alife.anotherlife.core.composable.lifecycle.OnLifecycle
import com.alife.anotherlife.theme.Shapes

@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
@ExperimentalAnimationApi
@Composable
fun VideoPlayerComposable(
    //preview: Bitmap,
    videoUrl: String,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val mediaItem = MediaItem.fromUri(Uri.parse(videoUrl))
    val mediaSource = ProgressiveMediaSource.Factory(DefaultDataSource.Factory(context)).createMediaSource(mediaItem)

    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            //setMediaItem(mediaItem)
            setMediaSource(mediaSource)
            videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT
            repeatMode = Player.REPEAT_MODE_ONE
            playWhenReady = true
            prepare()
        }
    }

    //exoPlayer.seekTo(playingIndex.value, C.TIME_UNSET)
    //exoPlayer.playWhenReady = true

    OnLifecycle { _, event ->
        when (event) {
            Lifecycle.Event.ON_RESUME -> exoPlayer.play()
            Lifecycle.Event.ON_DESTROY -> exoPlayer.pause()
            else -> Unit
        }
    }

    DisposableEffect(
        OutlinedCard(modifier = modifier, shape = Shapes.large) {
            AndroidView(
                factory = {
                    PlayerView(context).apply {
                        hideController()
                        useController = false
                        player = exoPlayer
                        resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
                        layoutParams = FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )
                    }
                })
        }
    ) {
        onDispose {
            exoPlayer.release()
        }
    }
}