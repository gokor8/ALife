package com.alife.domain.registration.usecase.reg_log.name

import com.alife.domain.registration.usecase.base.entity.RegCacheInputEntity

class NameSaveCacheEntity(val name: String) : RegCacheInputEntity.Save<String>