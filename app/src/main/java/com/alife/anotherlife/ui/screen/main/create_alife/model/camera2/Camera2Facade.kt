package com.alife.anotherlife.ui.screen.main.create_alife.model.camera2

import android.graphics.ImageFormat
import android.hardware.camera2.CameraCaptureSession
import android.hardware.camera2.CameraDevice
import android.media.ImageReader
import android.os.Handler
import android.util.Log
import android.view.Surface
import android.view.SurfaceView
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera2.camera_handler.BaseCameraThread
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class Camera2Facade(
    private val cameraWrapper: CameraWrapper,
    private val cameraThread: BaseCameraThread,
) {

    suspend fun setupCamera(surface: Surface) {
        val cameraDevice = cameraWrapper.openCamera()
        val size = cameraWrapper.getSize()

        val imageReader = ImageReader.newInstance(
            size.width,
            size.height,
            ImageFormat.JPEG,
            2
        )

        imageReader.setOnImageAvailableListener({ }, cameraThread.handler)

        val targets = listOf(surface, imageReader.surface)

        // Start a capture session using our open camera and list of Surfaces where frames will go
        val session = createCaptureSession(cameraDevice, targets, cameraThread.handler)

        val captureRequest = cameraDevice.createCaptureRequest(
            CameraDevice.TEMPLATE_PREVIEW).apply { addTarget(surface) }

        session.setRepeatingRequest(captureRequest.build(), null, cameraThread.handler)
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
}