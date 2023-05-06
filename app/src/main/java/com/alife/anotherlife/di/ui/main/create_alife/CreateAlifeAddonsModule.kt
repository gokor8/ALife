package com.alife.anotherlife.di.ui.main.create_alife

import androidx.camera.core.ImageCapture
import androidx.camera.video.FileOutputOptions
import androidx.camera.video.Recorder
import androidx.camera.video.VideoCapture
import androidx.camera.video.VideoRecordEvent
import androidx.core.util.Consumer
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.BaseCameraSetupFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.CaptureFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.DefaultPictureCaptureFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.ImageSetupFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.DefaultVideoCaptureFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.VideoSetupFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.callback.CallbackVideoEvent
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options.BaseFileOutputOptions
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface CreateAlifeAddonsModule {

    @Binds
    fun bindVideoSetupFactory(setupFactory: VideoSetupFactory): BaseCameraSetupFactory<BaseVideoCaptureWrapper>

    @Binds
    fun bindVideoCaptureFactory(captureFactory: DefaultVideoCaptureFactory): CaptureFactory<VideoCapture<Recorder>>

    @Binds
    fun bindImageSetupFactory(setupFactory: ImageSetupFactory): BaseCameraSetupFactory<BaseCaptureWrapper>

    @Binds
    fun bindImageCaptureFactory(captureFactory: DefaultPictureCaptureFactory): CaptureFactory<ImageCapture>

    @Binds
    fun bindCallbackVideoEvent(callback: CallbackVideoEvent): Consumer<VideoRecordEvent>

    @Binds
    fun bindDefaultFileOutputOptions(outputOptions: BaseFileOutputOptions.Default): BaseFileOutputOptions
}