package com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model

interface BaseLocationModel

class EmptyLocationModel : BaseLocationModel

class LocationModel(val longitude: Double, val latitude: Double) : BaseLocationModel