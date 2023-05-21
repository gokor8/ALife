package com.alife.domain.registration.usecase.email.save_read

import com.alife.domain.registration.usecase.base.entity.SaveCacheInputEntity

class EmailSaveCacheEntity(val email: String) : SaveCacheInputEntity<String>