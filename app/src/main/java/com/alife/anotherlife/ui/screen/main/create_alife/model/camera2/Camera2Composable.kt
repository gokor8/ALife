package com.alife.anotherlife.ui.screen.main.create_alife.model.camera2

import android.content.Context
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.hardware.camera2.params.StreamConfigurationMap
import android.util.Log
import android.util.Size
import android.view.Display
import android.view.Surface
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.TextureView
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera2.camera_cooker.CameraCooker
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera2.camera_cooker.CameraCooksState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera2.camera_handler.FrontCameraThread
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Camera2Composable(
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) {

    AndroidView(
        factory = { context ->
            SurfaceView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )

                holder.addCallback(object : SurfaceHolder.Callback {
                    override fun surfaceDestroyed(holder: SurfaceHolder) = Unit

                    override fun surfaceChanged(
                        holder: SurfaceHolder,
                        format: Int,
                        width: Int,
                        height: Int
                    ) = Unit

                    override fun surfaceCreated(holder: SurfaceHolder) {
                        val cameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
                        // Selects appropriate preview size and configures view finder
                        val previewSize = getPreviewOutputSize(
                            display,
                            cameraManager.getCameraCharacteristics("1"),
                            SurfaceHolder::class.java
                        )
                        this@apply.setAspectRatio(
                            previewSize.width,
                            previewSize.height
                        )

                        // To ensure that size is set, initialize camera in the view's thread
                        view.post { initializeCamera() }
                    }
                })
            }
        },
        update = { view ->
            val cameraManager =
                view.context.getSystemService(Context.CAMERA_SERVICE) as CameraManager

            coroutineScope.launch {
                val cooksState = CameraCooker().tryCook(cameraManager)

                if (cooksState is CameraCooksState.TwoCameras) {
                    val cameraWrapper = CameraWrapper(cooksState.frontCameraId, cameraManager)

                    Camera2Facade(
                        cameraWrapper,
                        FrontCameraThread()
                    ).setupCamera(view.holder.surface)
                }
            }
        }
    )
}

@Preview
@Composable
fun Camera2ComposablePreview() {
    Camera2Composable()
}

fun <T>getPreviewOutputSize(
    display: Display,
    characteristics: CameraCharacteristics,
    targetClass: Class<T>,
    format: Int? = null
): Size {

    // Find which is smaller: screen or 1080p
    val screenSize = getDisplaySmartSize(display)
    val hdScreen = screenSize.long >= SIZE_1080P.long || screenSize.short >= SIZE_1080P.short
    val maxSize = if (hdScreen) SIZE_1080P else screenSize

    // If image format is provided, use it to determine supported sizes; else use target class
    val config = characteristics.get(
        CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)!!
    if (format == null)
        assert(StreamConfigurationMap.isOutputSupportedFor(targetClass))
    else
        assert(config.isOutputSupportedFor(format))
    val allSizes = if (format == null)
        config.getOutputSizes(targetClass) else config.getOutputSizes(format)

    // Get available sizes and sort them by area from largest to smallest
    val validSizes = allSizes
        .sortedWith(compareBy { it.height * it.width })
        .map { SmartSize(it.width, it.height) }.reversed()

    // Then, get the largest output size that is smaller or equal than our max size
    return validSizes.first { it.long <= maxSize.long && it.short <= maxSize.short }.size
}