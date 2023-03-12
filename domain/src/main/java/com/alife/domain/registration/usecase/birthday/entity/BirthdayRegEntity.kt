package com.alife.domain.registration.usecase.birthday.entity

import com.alife.domain.registration.core.entity.BoxRegEntity
import com.alife.domain.registration.core.entity.DefaultRegEntity
import com.alife.domain.registration.core.entity.RegEntity

class BirthdayRegEntity(regEntity: RegEntity) : BoxRegEntity(regEntity) {

    constructor(birthday: String) : this(DefaultRegEntity.Success(birthday))
}