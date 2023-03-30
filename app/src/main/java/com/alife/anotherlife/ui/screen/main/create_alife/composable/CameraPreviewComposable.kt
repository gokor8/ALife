package com.alife.anotherlife.ui.screen.main.create_alife.composable

import android.content.Context
import android.view.ViewGroup
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.BaseCameraSetupFacade
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.CameraSetupFacade
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@Composable
fun CameraPreviewComposable(
    cameraSetup: BaseCameraSetupFacade,
    modifier: Modifier = Modifier,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    scaleType: PreviewView.ScaleType = PreviewView.ScaleType.FILL_CENTER,
    onSetupCamera: (BaseCaptureWrapper) -> Unit
) {
    val lifecycleOwner = LocalLifecycleOwner.current

    AndroidView(
        modifier = modifier,
        factory = { context ->
            val previewView = PreviewView(context).apply {
                this.scaleType = scaleType
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }

            coroutineScope.launch {
                onSetupCamera(
                    cameraSetup.setup(cameraProvider(context), previewView, lifecycleOwner)
                )
            }

            previewView
        }
    )
}

// TODO вынести в hilt
suspend fun cameraProvider(context: Context): ProcessCameraProvider {
    return suspendCoroutine { continuation ->
        ProcessCameraProvider.getInstance(context).also { future ->
            future.addListener({
                continuation.resume(future.get())
            }, ContextCompat.getMainExecutor(context))
        }
    }
}