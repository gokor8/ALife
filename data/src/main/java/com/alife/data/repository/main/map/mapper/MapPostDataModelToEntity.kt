package com.alife.data.repository.main.map.mapper

import com.alife.core.mapper.ListMapper
import com.alife.data.repository.main.map.model.MapPostDataModel
import com.alife.domain.core.MappingException
import com.alife.domain.main.map.MapPostEntity
import java.util.Date
import javax.inject.Inject

interface BaseMapPostDataModelToEntity : ListMapper<MapPostDataModel, MapPostEntity>

class MapPostDataModelToEntity @Inject constructor() : BaseMapPostDataModelToEntity {

    override fun map(inputModel: List<MapPostDataModel>): List<MapPostEntity> {
        val postEntityList = mutableListOf<MapPostEntity>()

        for (post in inputModel) {
            try {
                with(post) {
                    val preview = when {
                        video != null -> video
                        firstPhoto != null -> firstPhoto
                        else -> throw MappingException()
                    }

                    val latLng = getLatLng()

                    postEntityList.add(
                        MapPostEntity(
                            username,
                            Date(creationDate),
                            preview,
                            latLng.first,
                            latLng.second
                        )
                    )
                }
            } catch (e: NumberFormatException) {
                continue
            }
        }

        return postEntityList
    }
}