package com.alife.anotherlife.ui.screen.main.finish_create_alife.base_mapper

import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model.BaseLocationModel
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model.EmptyLocationModel
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model.LocationModel
import com.alife.core.mapper.Mapper
import com.alife.domain.core.MappingException
import com.alife.domain.main.finish_create_alife.BaseLocationEntity
import com.alife.domain.main.finish_create_alife.EmptyLocationEntity
import com.alife.domain.main.finish_create_alife.LocationEntity
import javax.inject.Inject

interface BaseLocationToEntityLocation : Mapper<BaseLocationModel, BaseLocationEntity>

class LocationToEntityLocation @Inject constructor() : BaseLocationToEntityLocation {

    override fun map(inputModel: BaseLocationModel) = when (inputModel) {
        is EmptyLocationModel -> EmptyLocationEntity()
        is LocationModel -> LocationEntity(inputModel.longitude, inputModel.latitude)
        else -> throw MappingException()
    }
}