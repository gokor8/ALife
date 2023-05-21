package com.alife.domain.registration.usecase.email.save_read

import com.alife.domain.registration.usecase.base.entity.RegCacheInputEntity

class EmailSaveCacheEntity(val email: String) : RegCacheInputEntity.Save<String>