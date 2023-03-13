package com.alife.domain.registration.usecase.username

import com.alife.domain.registration.usecase.base.entity.SaveRegInputEntity

class UsernameSaveRegEntity(val username: String) : SaveRegInputEntity<String>