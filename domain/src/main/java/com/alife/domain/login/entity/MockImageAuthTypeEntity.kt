package com.alife.domain.login.entity

sealed interface MockImageAuthTypeEntity : AuthTypeEntity {

    class VKAuthTypeEntity : MockImageAuthTypeEntity

    class InstagramAuthTypeEntity : MockImageAuthTypeEntity

    class GoogleAuthTypeEntity : MockImageAuthTypeEntity
}