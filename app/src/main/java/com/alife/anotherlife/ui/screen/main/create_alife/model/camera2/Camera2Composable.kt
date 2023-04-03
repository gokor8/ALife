package com.alife.anotherlife.ui.screen.main.create_alife.model.camera2

import android.content.Context
import android.graphics.ImageFormat
import android.hardware.camera2.CameraCaptureSession
import android.hardware.camera2.CameraDevice
import android.hardware.camera2.CameraManager
import android.media.ImageReader
import android.os.Handler
import android.util.Log
import android.view.Surface
import android.view.TextureView
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera2.camera_cooker.CameraCooker
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera2.camera_cooker.CameraCooksState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

@Composable
fun Camera2Composable(
    coroutineScope: CoroutineScope
) {

    AndroidView(
        factory = { context ->
            val view = TextureView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }

            val cameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager

            coroutineScope.launch {
                val cooksState = CameraCooker().tryCook(cameraManager)

                when (cooksState) {
                    is CameraCooksState.TwoCameras -> {
                        val cameraWrapper = CameraWrapper(cooksState.frontCameraId, cameraManager)

                        val camera = cameraWrapper.openCamera()
                        val size = cameraWrapper.getSize()

                        val imageReader = ImageReader.newInstance(
                            size.width,
                            size.height,
                            ImageFormat.JPEG,
                            2
                        )

                        val session =
                    }
                }

            }
            view
        }
    )
}

private suspend fun createCaptureSession(
    device: CameraDevice,
    targets: List<Surface>,
    handler: Handler? = null
): CameraCaptureSession = suspendCoroutine { cont ->

    // Create a capture session using the predefined targets; this also involves defining the
    // session state callback to be notified of when the session is ready
    device.createCaptureSession(targets, object : CameraCaptureSession.StateCallback() {

        override fun onConfigured(session: CameraCaptureSession) = cont.resume(session)

        override fun onConfigureFailed(session: CameraCaptureSession) {
            val exc = RuntimeException("Camera ${device.id} session configuration failed")
            Log.e("Camera", exc.message, exc)
            cont.resumeWithException(exc)
        }
    }, handler)
}