package com.alife.anotherlife.ui.screen.main.finish_create_alife.video.composable

import android.net.Uri
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.common.Player
import androidx.media3.common.util.Util
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.datasource.cache.CacheDataSource
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
    exoPlayer: ExoPlayer,
    videoUrl: String,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    LaunchedEffect(videoUrl) {
        exoPlayer.apply {
            val dataSourceFactory = DefaultHttpDataSource.Factory()
                .setUserAgent(Util.getUserAgent(context, context.packageName))
            val source = ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(MediaItem.fromUri(videoUrl))

            setMediaSource(source)
            prepare()
            playWhenReady = true
        }
    }

    val lifecycleOwner by rememberUpdatedState(LocalLifecycleOwner.current)
    DisposableEffect(lifecycleOwner) {
        val lifecycle = lifecycleOwner.lifecycle
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_PAUSE -> exoPlayer.playWhenReady = false
                Lifecycle.Event.ON_RESUME -> exoPlayer.playWhenReady = true
                Lifecycle.Event.ON_DESTROY -> {
                    exoPlayer.stop()
                    exoPlayer.release()
                }
                else -> {}
            }
        }
        lifecycle.addObserver(observer)
        onDispose {
            lifecycle.removeObserver(observer)
        }
    }

//    OnLifecycle { _, event ->
//        when (event) {
//            Lifecycle.Event.ON_RESUME -> exoPlayer.play()
//            Lifecycle.Event.ON_DESTROY -> exoPlayer.pause()
//            else -> Unit
//        }
//    }

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
}