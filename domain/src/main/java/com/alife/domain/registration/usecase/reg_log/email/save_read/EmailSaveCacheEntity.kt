package com.alife.domain.registration.usecase.reg_log.email.save_read

import com.alife.domain.registration.usecase.base.entity.RegCacheInputEntity

class EmailSaveCacheEntity(val email: String) : RegCacheInputEntity.Save<String>