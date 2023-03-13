package com.alife.domain.registration.usecase.email.send_reg_data.entity

import com.alife.core.usecase.UseCaseEntity

class RegDataEntity(
    val name: String,
    val username: String,
    val birthday: String,
    val email: String
) : UseCaseEntity