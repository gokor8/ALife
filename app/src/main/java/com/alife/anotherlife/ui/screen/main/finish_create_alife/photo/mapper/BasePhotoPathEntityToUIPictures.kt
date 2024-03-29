package com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.mapper

import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.model.UILocalPicturesModel
import com.alife.core.mapper.Mapper
import com.alife.domain.main.create_alife.picture.entity.PhotoPathEntity
import javax.inject.Inject

interface BasePhotoPathEntityToUIPictures : Mapper<PhotoPathEntity, UILocalPicturesModel>

class PhotoPathEntityToUIPictures @Inject constructor() : BasePhotoPathEntityToUIPictures {
    override fun map(inputModel: PhotoPathEntity) = with(inputModel) {
        UILocalPicturesModel(firstUrl, secondUrl)
    }
}