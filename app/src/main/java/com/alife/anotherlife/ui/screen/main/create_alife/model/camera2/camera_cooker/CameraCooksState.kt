package com.alife.anotherlife.ui.screen.main.create_alife.model.camera2.camera_cooker

interface CameraCooksState {

    fun copy(otherCameraId: String): CameraCooksState

    abstract class OneCamera(protected val cameraId: String) : CameraCooksState

    class FrontCamera(frontCameraId: String) : OneCamera(frontCameraId) {
        override fun copy(otherCameraId: String) = TwoCameras(cameraId, otherCameraId)
    }

    class BackCamera(backCameraId: String) : OneCamera(backCameraId) {
        override fun copy(otherCameraId: String) = TwoCameras(otherCameraId, cameraId)
    }

    class TwoCameras(
        val frontCameraId: String,
        val backCameraId: String
    ) : CameraCooksState {
        override fun copy(otherCameraId: String) = this
    }

    class ErrorFindCameras : CameraCooksState {
        override fun copy(otherCameraId: String) = this
    }
}