package com.alife.anotherlife.ui.screen.main.finish_create_alife.video.composable

import android.net.Uri
import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import com.alife.anotherlife.theme.Shapes
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.model.ExoPlayerSetupState

@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
@Composable
fun VideoPlayerComposable(
    exoPlayerSetupState: ExoPlayerSetupState,
    modifier: Modifier = Modifier,
) {
    OutlinedCard(modifier = modifier, shape = Shapes.large) {
        val context = LocalContext.current

        val exoPlayer = remember {
            ExoPlayer.Builder(context).build().apply {
                exoPlayerSetupState.setup(this)
            }
        }

        exoPlayerSetupState.afterSetup(exoPlayer)

        DisposableEffect(
            AndroidView(factory = {
                PlayerView(context).apply {
                    //hideController()
                    //useController = false
                    setShowBuffering(PlayerView.SHOW_BUFFERING_ALWAYS)
                    resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM

                    player = exoPlayer
                    layoutParams = FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
                    )
                }
            })
        ) {
            onDispose {
                Log.d("ExoPlayer $exoPlayer", "release")
                exoPlayer.release()
            }
        }
    }
}

@Composable
@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
fun VideoPlayer(
    uri: Uri,
    exoPlayerSetupState: ExoPlayerSetupState,
    modifier: Modifier = Modifier,
    isPlaying: Boolean
) {
    val context = LocalContext.current

    Box(modifier = modifier) {
        val exoPlayer = remember {
            ExoPlayer.Builder(context).build().apply {
                exoPlayerSetupState.setup(this)
            //                videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT
//                repeatMode = Player.REPEAT_MODE_ALL
//                setMediaItem(MediaItem.fromUri(uri))
//                prepare()
            }
        }

        if (isPlaying)
            exoPlayer.play()
        else
            exoPlayer.pause()
        //exoPlayer.repeatMode = Player.REPEAT_MODE_ONE

        DisposableEffect(
            AndroidView(factory = {
                PlayerView(context).apply {
                    hideController()
                    useController = false
                    setShowBuffering(PlayerView.SHOW_BUFFERING_ALWAYS)
                    resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM

                    player = exoPlayer
                    layoutParams = FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                }
            })
        ) {
            onDispose {
                Log.d("aboba", "released")
                exoPlayer.release()
            }
        }
    }
}