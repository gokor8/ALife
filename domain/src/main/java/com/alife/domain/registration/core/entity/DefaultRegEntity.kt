package com.alife.domain.registration.core.entity

interface DefaultRegEntity : RegEntity {

    class Success(val result: String) : DefaultRegEntity, RegEntity.Success
    class Fail(val throwable: Throwable) : DefaultRegEntity, RegEntity.Fail
}