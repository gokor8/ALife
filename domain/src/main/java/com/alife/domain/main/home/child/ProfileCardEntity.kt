package com.alife.domain.main.home.child

import java.util.Date

class ProfileCardEntity(
    val username: String,
    val frontAlife: String,
    val backAlife: String,
    val timestamp: Date,
    val avatar: String? = null
)