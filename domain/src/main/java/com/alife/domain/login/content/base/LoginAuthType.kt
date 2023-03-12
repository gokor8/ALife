package com.alife.domain.login.content.base

import com.alife.domain.login.content.entity.LoginAuthTypeEntity

interface LoginAuthType {

    fun getLoginAuthTypes(): LoginAuthTypeEntity
}