package com.alife.anotherlife.ui.screen.main.create_alife.model.camera2.camera_cooker

import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.util.Log
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class CameraCooker {

    suspend fun tryCook(
        cameraManager: CameraManager
    ) = suspendCoroutine { continuation ->
        var cameraCooksState: CameraCooksState? = null

        try {
            cameraManager.cameraIdList.forEach { cameraId ->
                Log.d("Camera", cameraId)

                val facing = cameraManager.getCameraCharacteristics(cameraId).run {
                    get(CameraCharacteristics.LENS_FACING)
                }

                if (facing == CameraCharacteristics.LENS_FACING_FRONT) {
                    cameraCooksState =
                        cameraCooksState?.copy(cameraId) ?: CameraCooksState.FrontCamera(cameraId)
                } else if (facing == CameraCharacteristics.LENS_FACING_BACK) {
                    cameraCooksState =
                        cameraCooksState?.copy(cameraId) ?: CameraCooksState.BackCamera(cameraId)
                }
            }
            Log.d("Camera Cook State", cameraCooksState.toString())
        } catch (e: CameraAccessException) {
            cameraCooksState = CameraCooksState.ErrorFindCameras()
        }

        continuation.resume(cameraCooksState ?: CameraCooksState.ErrorFindCameras())
    }
}