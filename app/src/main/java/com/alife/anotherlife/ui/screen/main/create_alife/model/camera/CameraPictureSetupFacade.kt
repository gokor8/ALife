package com.alife.anotherlife.ui.screen.main.create_alife.model.camera

import android.icu.text.AlphabeticIndex.Record
import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.core.UseCase
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.video.Recorder
import androidx.camera.video.VideoCapture
import androidx.camera.view.PreviewView
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LifecycleOwner
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.CaptureFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.BaseCameraSetupFacade
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.ErrorCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.ErrorVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.VideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options.VideoRecorder
import java.io.File
import javax.inject.Inject

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

            // Must unbind the use-cases before rebinding them.
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