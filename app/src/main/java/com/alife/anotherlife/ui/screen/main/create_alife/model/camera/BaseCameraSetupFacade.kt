package com.alife.anotherlife.ui.screen.main.create_alife.model.camera

import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.lifecycle.LifecycleOwner
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper

interface BaseCameraSetupFacade {

    fun setup(
        processCameraProvider: ProcessCameraProvider,
        previewView: PreviewView,
        lifecycleOwner: LifecycleOwner
    ): BaseCaptureWrapper
}