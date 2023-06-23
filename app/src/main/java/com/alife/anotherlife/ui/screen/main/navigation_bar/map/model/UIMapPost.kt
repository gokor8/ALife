package com.alife.anotherlife.ui.screen.main.navigation_bar.map.model

import com.mapbox.geojson.Point

class UIMapPost(
    val username: String,
    val creationDate: String,
    val preview: String,
    val point: Point,
)