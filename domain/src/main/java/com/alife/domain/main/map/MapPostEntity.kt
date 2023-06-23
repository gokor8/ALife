package com.alife.domain.main.map

import java.util.Date

class MapPostEntity(
    val username: String,
    val creationDate: Date,
    val preview: String,
    val longitude: Double,
    val latitude: Double
)