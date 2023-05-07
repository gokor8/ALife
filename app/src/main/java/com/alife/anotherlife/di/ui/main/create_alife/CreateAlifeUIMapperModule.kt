package com.alife.anotherlife.di.ui.main.create_alife

import androidx.camera.core.ImageProxy
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.BaseCameraStateToSaveImage
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.CameraStateToSaveImage
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.ImageProxySelectMapper
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.mapper.BaseVideoCaptureWrapperToState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.mapper.BaseVideoStorageToOptions
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.mapper.VideoCaptureWrapperToState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.mapper.VideoStorageToOptions
import com.alife.core.mapper.Mapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface CreateAlifeUIMapperModule {

    @Binds
    fun bindVideoCaptureWrapperToState(mapper: VideoCaptureWrapperToState): BaseVideoCaptureWrapperToState

    @Binds
    fun bindVideoStorageToOptions(mapper: VideoStorageToOptions): BaseVideoStorageToOptions

    @Binds
    fun bindImageProxySelectMapper(mapper: ImageProxySelectMapper): Mapper<ImageProxy, ByteArray>

    @Binds
    fun bindCameraStateToSaveImage(mapper: CameraStateToSaveImage): BaseCameraStateToSaveImage

}