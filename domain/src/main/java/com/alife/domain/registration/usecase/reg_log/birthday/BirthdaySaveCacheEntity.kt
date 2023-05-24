package com.alife.domain.registration.usecase.reg_log.birthday

import com.alife.domain.registration.usecase.base.entity.RegCacheInputEntity

class BirthdaySaveCacheEntity(val birthday: String) : RegCacheInputEntity.Save<String>