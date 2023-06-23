package com.alife.anotherlife.ui.screen.main.navigation_bar.map.mapper

import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BaseDateAgoFormatMapper
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.model.MapElementModel
import com.alife.core.mapper.ListMapper
import com.alife.domain.main.map.MapPostEntity
import com.mapbox.geojson.Point
import javax.inject.Inject

interface BaseMapPostEntityToUI : ListMapper<MapPostEntity, MapElementModel>

class MapPostEntityToUI @Inject constructor(
    private val dateAgoFormatMapper: BaseDateAgoFormatMapper
) : BaseMapPostEntityToUI {

    override fun map(inputModel: List<MapPostEntity>) = inputModel.map { post ->
        with(post) {
            MapElementModel.ImageElement(
                username,
                dateAgoFormatMapper.map(creationDate),
                preview,
                Point.fromLngLat(longitude, latitude)
            )
        }
    }
}