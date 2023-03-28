package com.alife.domain.registration.core.entity

// TODO Need full remove
interface DefaultRegEntity : RegEntity {

    class Success(val result: String) : DefaultRegEntity, RegEntity.Success
    class Fail(val throwable: Throwable) : DefaultRegEntity, RegEntity.Fail
}