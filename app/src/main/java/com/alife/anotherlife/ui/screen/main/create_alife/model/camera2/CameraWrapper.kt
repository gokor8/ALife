package com.alife.anotherlife.ui.screen.main.create_alife.model.camera2

import android.annotation.SuppressLint
import android.graphics.ImageFormat
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraDevice
import android.hardware.camera2.CameraManager
import android.os.Handler
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera2.callback.SuspendCameraDeviceCallback
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.suspendCancellableCoroutine

class CameraWrapper(
    private val cameraId: String,
    private val cameraManager: CameraManager
) {

    private val handler: Handler? = null

    @SuppressLint("MissingPermission")
    suspend fun openCamera() = suspendCancellableCoroutine {
        cameraManager.openCamera(
            cameraId,
            SuspendCameraDeviceCallback(cameraId, it),
            handler
        )
    }

    fun getSize() = cameraManager.getCameraCharacteristics(cameraId).get(
        CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP
    )!!
        .getOutputSizes(ImageFormat.JPEG).maxByOrNull { it.height * it.width }!!
}