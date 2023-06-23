package com.alife.domain.main.finish_create_alife

interface BaseLocationEntity

class EmptyLocationEntity : BaseLocationEntity

class LocationEntity(val longitude: Double, val latitude: Double) : BaseLocationEntity