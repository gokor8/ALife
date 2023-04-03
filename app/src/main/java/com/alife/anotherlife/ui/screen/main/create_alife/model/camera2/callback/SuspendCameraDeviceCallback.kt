package com.alife.anotherlife.ui.screen.main.create_alife.model.camera2.callback

import android.hardware.camera2.CameraDevice
import android.util.Log
import kotlinx.coroutines.CancellableContinuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class SuspendCameraDeviceCallback(
    private val cameraId: String,
    private val continuation: CancellableContinuation<CameraDevice>
) : CameraDevice.StateCallback() {

    private val logId = "Camera Callback"

    override fun onOpened(camera: CameraDevice) {
        Log.d(logId, "Open camera  with id:"+camera.id)
        continuation.resume(camera)
    }

    override fun onDisconnected(camera: CameraDevice) {
        Log.d(logId, "disconnect camera  with id:"+camera.id)
        camera.close()
    }

    override fun onError(camera: CameraDevice, error: Int) {
        val msg = when (error) {
            ERROR_CAMERA_DEVICE -> "Fatal (device)"
            ERROR_CAMERA_DISABLED -> "Device policy"
            ERROR_CAMERA_IN_USE -> "Camera in use"
            ERROR_CAMERA_SERVICE -> "Fatal (service)"
            ERROR_MAX_CAMERAS_IN_USE -> "Maximum cameras in use"
            else -> "Unknown"
        }
        val exc = RuntimeException("Camera $cameraId error: ($error) $msg")
        Log.e(logId, exc.message, exc)
        if (continuation.isActive) continuation.resumeWithException(exc)
    }
}