package com.alife.domain.registration.usecase.birthday

import com.alife.domain.registration.usecase.base.entity.SaveCacheInputEntity

class BirthdaySaveCacheEntity(val birthday: String) : SaveCacheInputEntity<String>