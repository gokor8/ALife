package com.alife.domain.registration.usecase.name.addons

import com.alife.domain.registration.core.entity.BoxRegEntity
import com.alife.domain.registration.core.entity.DefaultRegEntity
import com.alife.domain.registration.core.entity.RegEntity

class NameRegEntity(regEntity: RegEntity) : BoxRegEntity(regEntity) {

    constructor(name: String) : this(DefaultRegEntity.Success(name))
}