package com.alife.domain.registration.usecase.name

import com.alife.domain.registration.usecase.base.entity.RegCacheInputEntity

class NameSaveCacheEntity(val name: String) : RegCacheInputEntity.Save<String>