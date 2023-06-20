package com.alife.anotherlife.ui.screen.main.navigation_bar.map.mapper

import com.alife.anotherlife.ui.screen.main.navigation_bar.map.model.UIMapPost
import com.alife.core.mapper.Mapper
import com.alife.domain.main.map.MapPostEntity
import javax.inject.Inject

interface BaseMapPostEntityToUI : Mapper<MapPostEntity, UIMapPost>

class MapPostEntityToUI @Inject constructor() : BaseMapPostEntityToUI {

    override fun map(inputModel: MapPostEntity) = with(inputModel) {
        UIMapPost(username, creationDate, preview, longitude, latitude)
    }
}