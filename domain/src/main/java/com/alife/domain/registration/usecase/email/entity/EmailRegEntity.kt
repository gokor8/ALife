package com.alife.domain.registration.usecase.email.entity

import com.alife.domain.registration.core.entity.BoxerRegEntity
import com.alife.domain.registration.core.entity.DefaultRegEntity
import com.alife.domain.registration.core.entity.RegEntity

class EmailRegEntity(regEntity: RegEntity) : BoxerRegEntity(regEntity) {

    constructor(birthday: String) : this(DefaultRegEntity.Success(birthday))
}