package com.alife.domain.registration.usecase.username

import com.alife.domain.registration.usecase.base.entity.RegCacheInputEntity

class UsernameSaveCacheEntity(val username: String) : RegCacheInputEntity.Save<String>