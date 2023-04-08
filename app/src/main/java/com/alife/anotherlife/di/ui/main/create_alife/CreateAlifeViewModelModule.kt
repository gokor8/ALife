package com.alife.anotherlife.di.ui.main.create_alife

import com.alife.anotherlife.ui.screen.main.create_alife.BaseCreateAlifeReducer
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeReducer
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.BaseCameraStateToSaveImage
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.CameraStateToSaveImage
import com.alife.data.repository.main.create_alife.CreateAlifeRepository
import com.alife.data.repository.main.create_alife.mapper.BaseEntityToReadModel
import com.alife.data.repository.main.create_alife.mapper.BaseEntityToSaveModel
import com.alife.data.repository.main.create_alife.mapper.EntityToReadModel
import com.alife.data.repository.main.create_alife.mapper.EntityToSaveModel
import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.main.create_alife.BaseSaveAlifeUseCase
import com.alife.domain.main.create_alife.SaveAlifeUseCase
import com.alife.domain.main.create_alife.mapper.AlifeThrowableUCMapper
import com.alife.domain.main.create_alife.repository.BaseCreateAlifeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface CreateAlifeViewModelModule {

    @Binds
    fun bindCreateAlifeReducer(reducer: CreateAlifeReducer): BaseCreateAlifeReducer

    @Binds
    fun bindCameraStateToSaveImage(cameraStateToSaveImage: CameraStateToSaveImage): BaseCameraStateToSaveImage

    @Binds
    fun bindSaveAlifeUseCase(saveAlifeUseCase: SaveAlifeUseCase): BaseSaveAlifeUseCase

    @Binds
    fun bindCreateAlifeRepository(createAlifeRepository: CreateAlifeRepository): BaseCreateAlifeRepository

    @Binds
    fun bindCreateAlifeThrowableUCMapper(mapper: AlifeThrowableUCMapper): ThrowableUCMapper<Unit>

    @Binds
    fun bindEntityToSaveModel(mapper: EntityToSaveModel): BaseEntityToSaveModel

    @Binds
    fun bindEntityToReadModel(mapper: EntityToReadModel): BaseEntityToReadModel
}