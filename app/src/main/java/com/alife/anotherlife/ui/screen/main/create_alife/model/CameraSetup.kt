package com.alife.anotherlife.ui.screen.main.create_alife.model

import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.lifecycle.LifecycleOwner

class CameraSetup(
    private val cameraSelector: CameraSelector,
    private val previewBuilder: Preview.Builder,
    private val captureFactory: ImageCaptureFactory
) {

    fun setup(
        processCameraProvider: ProcessCameraProvider,
        previewView: PreviewView,
        lifecycleOwner: LifecycleOwner
    ): CameraWrapper {
        val preview = previewBuilder.build().apply {
            setSurfaceProvider(previewView.surfaceProvider)
        }
        val imageCapture = captureFactory.create(previewView.display.rotation)

        try {
            // Must unbind the use-cases before rebinding them.
            processCameraProvider.unbindAll()
            processCameraProvider.bindToLifecycle(
                lifecycleOwner,
                cameraSelector,
                preview,
                imageCapture
            )
        } catch (ex: Exception) {
            // setScreenError and go back from camera
            Log.e("CameraPreview", "Use case binding failed", ex)
        }

        return CameraWrapper(imageCapture)
    }
}