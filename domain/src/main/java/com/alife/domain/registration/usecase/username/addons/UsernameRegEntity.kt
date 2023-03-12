package com.alife.domain.registration.usecase.username.addons

import com.alife.domain.registration.core.entity.BoxRegEntity
import com.alife.domain.registration.core.entity.DefaultRegEntity
import com.alife.domain.registration.core.entity.RegEntity

class UsernameRegEntity(regEntity: RegEntity) : BoxRegEntity(regEntity) {

    constructor(username: String) : this(DefaultRegEntity.Success(username))
}