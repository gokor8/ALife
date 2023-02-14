package com.alife.domain.login.entity

sealed interface DefaultAuthTypeEntity : AuthTypeEntity {

    class LoginInEntity : DefaultAuthTypeEntity

    class RegistrationEntity : DefaultAuthTypeEntity

    class HorizontalLogoEntity : DefaultAuthTypeEntity

    class HintEntity : DefaultAuthTypeEntity
}