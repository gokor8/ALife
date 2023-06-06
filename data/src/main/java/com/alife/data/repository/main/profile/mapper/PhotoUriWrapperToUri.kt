package com.alife.data.repository.main.profile.mapper

import androidx.core.net.toFile
import com.alife.core.mapper.Mapper
import com.alife.data.repository.main.profile.model.PhotoUriWrapper
import com.alife.domain.core.MappingException
import com.alife.domain.main.profile.entity.BasePhotoUriWrapper
import java.io.File
import javax.inject.Inject

interface BasePhotoUriWrapperToUri : Mapper<BasePhotoUriWrapper, File>

class PhotoUriWrapperToUri @Inject constructor() : BasePhotoUriWrapperToUri{

    override fun map(inputModel: BasePhotoUriWrapper): File {
        return if(inputModel is PhotoUriWrapper) {
            inputModel.uri.toFile()
        } else throw MappingException()
    }
}