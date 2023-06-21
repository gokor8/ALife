package com.alife.data.repository.main.map

import com.alife.data.repository.main.map.mapper.BaseMapPostDataModelToEntity
import com.alife.data.services.MapService
import com.alife.domain.main.map.BaseMapRepository
import javax.inject.Inject

class MapRepository @Inject constructor(
    private val mapPostDataModelToEntity: BaseMapPostDataModelToEntity,
    private val mapService: MapService
) : BaseMapRepository {

    override suspend fun getMapPostList() =
        mapPostDataModelToEntity.map(mapService.getMapPosts())
}