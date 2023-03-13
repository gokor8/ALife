package com.alife.domain.registration.usecase.email.save_read

import com.alife.domain.registration.usecase.base.entity.SaveRegInputEntity

class EmailSaveRegEntity(val email: String) : SaveRegInputEntity<String>