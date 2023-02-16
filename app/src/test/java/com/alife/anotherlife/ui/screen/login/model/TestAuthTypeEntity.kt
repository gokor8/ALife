package com.alife.anotherlife.ui.screen.login.model

import com.alife.domain.login.entity.AuthTypeEntity

sealed interface TestAuthTypeEntity : AuthTypeEntity {

    class BadAuthType : TestAuthTypeEntity
    class TestFirstAuthType : TestAuthTypeEntity
    class TestSecondAuthType : TestAuthTypeEntity
}