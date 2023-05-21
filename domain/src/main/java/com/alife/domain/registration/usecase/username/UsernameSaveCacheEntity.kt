package com.alife.domain.registration.usecase.username

import com.alife.domain.registration.usecase.base.entity.SaveCacheInputEntity

class UsernameSaveCacheEntity(val username: String) : SaveCacheInputEntity<String>