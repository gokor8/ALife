package com.alife.domain.registration.usecase.reg_log.username

import com.alife.domain.registration.usecase.base.entity.RegCacheInputEntity

class UsernameSaveCacheEntity(val username: String) : RegCacheInputEntity.Save<String>