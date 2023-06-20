package com.alife.anotherlife.ui.screen.main.finish_create_alife.photo

import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.finish_create_alife.BaseCreateFinishReducer
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_mapper.BaseLocationToEntityLocation
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_mapper.BasePhotoFinishExceptionMapper
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.mapper.BasePhotoPathEntityToUIPictures
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state.FinishPictureState
import com.alife.domain.main.create_alife.picture.BasePhotoStorageAlifeUseCase
import com.alife.domain.main.finish_create_alife.BasePhotoFinishLoadUseCase
import javax.inject.Inject

class FinishPictureReducer @Inject constructor(
    override val uiStore: UIStore<FinishPictureState, FinishEffect>,
    private val photoStorageAlifeUseCase: BasePhotoStorageAlifeUseCase,
    private val photoPathEntityToUIPictures: BasePhotoPathEntityToUIPictures,
    private val exceptionMapper: BasePhotoFinishExceptionMapper,
    locationModelMapper: BaseLocationToEntityLocation,
    finishLoadUseCase: BasePhotoFinishLoadUseCase
) : BaseCreateFinishReducer.Abstract<FinishPictureState>(finishLoadUseCase, locationModelMapper),
    BaseFinishPictureReducer {

    override suspend fun onInit() {
        setState { copy(lceModel = LCELoading) }

        executeThis(getState()) { exception ->
            copy(lceModel = exceptionMapper.map(this@FinishPictureReducer, exception))
        }.handleThis(getState()) {
            val uiPictures = photoPathEntityToUIPictures.map(
                photoStorageAlifeUseCase.getPictures()
            )

            copy(lceModel = LCEContent, uiLocalPicturesModel = uiPictures)
        }.let(::setState)
    }
}