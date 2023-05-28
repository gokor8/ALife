package com.alife.domain.main.home.child

import java.util.Date

interface ProfileCardEntity {

    val username: String
    val frontAlife: String
    val backAlife: String
    val timestamp: Date
    val avatar: String?

    class Blured(
        override val username: String,
        override val frontAlife: String,
        override val backAlife: String,
        override val timestamp: Date,
        override val avatar: String?
    ): ProfileCardEntity

    class Normal(
        override val username: String,
        override val frontAlife: String,
        override val backAlife: String,
        override val timestamp: Date,
        override val avatar: String?
    ): ProfileCardEntity
}