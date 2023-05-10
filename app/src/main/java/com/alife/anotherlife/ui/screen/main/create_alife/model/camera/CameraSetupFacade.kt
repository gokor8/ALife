package com.alife.anotherlife.ui.screen.main.create_alife.model.camera

import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.core.UseCase
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.lifecycle.LifecycleOwner
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.CaptureFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.BaseCameraSetupFacade

abstract class CameraSetupFacade<M : UseCase, R : Any>(
    private val cameraSelector: CameraSelector,
    private val previewBuilder: Preview.Builder,
    private val captureFactory: CaptureFactory<M>
) : BaseCameraSetupFacade<R> {
    override fun setup(
        processCameraProvider: ProcessCameraProvider,
        previewView: PreviewView,
        lifecycleOwner: LifecycleOwner
    ): R {
        val preview = previewBuilder.build().apply {
            setSurfaceProvider(previewView.surfaceProvider)
        }

        return try {
            val capture = captureFactory.create(previewView.display.rotation)

            processCameraProvider.unbindAll()
            processCameraProvider.bindToLifecycle(
                lifecycleOwner,
                cameraSelector,
                preview,
                capture
            )

            onBind(capture)
        } catch (ex: Exception) {
            Log.e("CameraPreview", "Use case binding failed", ex)
            onException(ex)
        }
    }

    abstract fun onBind(capture: M): R
    abstract fun onException(ex: Exception): R
}