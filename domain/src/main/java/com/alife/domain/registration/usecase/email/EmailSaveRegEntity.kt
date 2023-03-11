package com.alife.domain.registration.usecase.email

import com.alife.domain.registration.usecase.base.SaveRegInputEntity

class EmailSaveRegEntity(val email: String) : SaveRegInputEntity<String>