package com.alife.domain.login.content.entity

sealed interface MockImageAuthTypeEntity : AuthTypeEntity {

    class VKAuthTypeEntity : MockImageAuthTypeEntity

    class InstagramAuthTypeEntity : MockImageAuthTypeEntity

    class GoogleAuthTypeEntity : MockImageAuthTypeEntity
}