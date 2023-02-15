package com.alife.domain.login.base

import com.alife.domain.login.entity.MockImageAuthTypeEntity

interface ListAuthType {

    fun getAuthTypes(): List<MockImageAuthTypeEntity>
}