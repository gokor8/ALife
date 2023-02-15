package com.alife.domain.login.base

import com.alife.domain.login.entity.LoginAuthTypeEntity

interface LoginAuthType {

    fun getLoginAuthTypes(): LoginAuthTypeEntity
}