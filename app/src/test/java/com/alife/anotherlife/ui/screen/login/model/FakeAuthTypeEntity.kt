package com.alife.anotherlife.ui.screen.login.model

import com.alife.domain.login.content.entity.AuthTypeEntity

sealed interface FakeAuthTypeEntity : AuthTypeEntity {

    class BadAuthType : FakeAuthTypeEntity
    class FakeFirstAuthType : FakeAuthTypeEntity
    class FakeSecondAuthType : FakeAuthTypeEntity
}