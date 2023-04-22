package com.alife.anotherlife.ui.screen.main.create_alife.model.camera

import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.lifecycle.LifecycleOwner
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.ImageCaptureFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.BaseCameraSetupFacade
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.ErrorCaptureWrapper

class CameraSetupFacade(
    private val cameraSelector: CameraSelector,
    private val previewBuilder: Preview.Builder,
    private val captureFactory: ImageCaptureFactory
) : BaseCameraSetupFacade {

    override fun setup(
        processCameraProvider: ProcessCameraProvider,
        previewView: PreviewView,
        lifecycleOwner: LifecycleOwner
    ): BaseCaptureWrapper {
        val preview = previewBuilder.build().apply {
            setSurfaceProvider(previewView.surfaceProvider)
        }
        val imageCapture = captureFactory.create(previewView.display.rotation)

        return try {
            // Must unbind the use-cases before rebinding them.
            processCameraProvider.unbindAll()
            processCameraProvider.bindToLifecycle(
                lifecycleOwner,
                cameraSelector,
                preview,
                imageCapture
            )

            CaptureWrapper(imageCapture)
        } catch (ex: Exception) {
            Log.e("CameraPreview", "Use case binding failed", ex)
            ErrorCaptureWrapper()
        }
    }
}