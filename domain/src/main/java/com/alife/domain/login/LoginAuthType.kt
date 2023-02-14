package com.alife.domain.login

import com.alife.domain.login.entity.AuthTypeEntity

interface LoginAuthType {

    fun getAuthTypes(): List<AuthTypeEntity>
}