package com.alife.domain.registration.usecase.username.addons

import com.alife.domain.registration.core.entity.BoxerRegEntity
import com.alife.domain.registration.core.entity.DefaultRegEntity
import com.alife.domain.registration.core.entity.RegEntity

class UsernameRegEntity(regEntity: RegEntity) : BoxerRegEntity(regEntity) {

    constructor(username: String) : this(DefaultRegEntity.Success(username))
}