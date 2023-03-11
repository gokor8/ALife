package com.alife.domain.registration.usecase.birthday

import com.alife.domain.registration.usecase.base.SaveRegInputEntity

class BirthdaySaveRegEntity(val birthday: String) : SaveRegInputEntity<String>