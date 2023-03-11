package com.alife.domain.registration.usecase.name.addons

import com.alife.domain.registration.core.entity.BoxerRegEntity
import com.alife.domain.registration.core.entity.DefaultRegEntity
import com.alife.domain.registration.core.entity.RegEntity

class NameRegEntity(regEntity: RegEntity) : BoxerRegEntity(regEntity) {

    constructor(name: String) : this(DefaultRegEntity.Success(name))
}