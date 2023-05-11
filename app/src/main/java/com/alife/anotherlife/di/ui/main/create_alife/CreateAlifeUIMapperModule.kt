package com.alife.anotherlife.di.ui.main.create_alife

import androidx.camera.core.ImageProxy
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.ActionScopedMapper
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.BaseActionScopedMapper
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.BaseCameraStateToSaveImage
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.CameraStateToSaveImage
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.image.BaseBitmapRotation
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.image.BaseBitmapToByteArray
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.image.BaseImageProxyToBitmap
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.image.BaseImageProxyToBytes
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.image.BitmapRotation
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.image.BitmapToByteArray
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.image.ImageProxyToBitmap
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.image.ImageProxyToBytes
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.mapper.BaseVideoCaptureWrapperToState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.mapper.BaseVideoStorageToOptions
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.mapper.VideoCaptureWrapperToState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.mapper.VideoStorageToOptions
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface CreateAlifeUIMapperModule {

    @Binds
    fun bindActionScopedMapper(mapper: ActionScopedMapper): BaseActionScopedMapper

    @Binds
    fun bindVideoCaptureWrapperToState(mapper: VideoCaptureWrapperToState): BaseVideoCaptureWrapperToState

    @Binds
    fun bindVideoStorageToOptions(mapper: VideoStorageToOptions): BaseVideoStorageToOptions

    @Binds
    fun bindImageProxySelectMapper(mapper: ImageProxyToBytes): BaseImageProxyToBytes
    @Binds
    fun bindImageProxyToBitmap(mapper: ImageProxyToBitmap): BaseImageProxyToBitmap
    @Binds
    fun bindBitmapRotation(mapper: BitmapRotation): BaseBitmapRotation
    @Binds
    fun bindBitmapToByteArray(mapper: BitmapToByteArray): BaseBitmapToByteArray

    @Binds
    fun bindCameraStateToSaveImage(mapper: CameraStateToSaveImage): BaseCameraStateToSaveImage

}