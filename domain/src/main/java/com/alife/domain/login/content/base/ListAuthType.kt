package com.alife.domain.login.content.base

import com.alife.domain.login.content.entity.MockImageAuthTypeEntity

interface ListAuthType {

    fun getAuthTypes(): List<MockImageAuthTypeEntity>
}