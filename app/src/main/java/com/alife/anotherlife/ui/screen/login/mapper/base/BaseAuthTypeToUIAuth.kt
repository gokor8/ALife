package com.alife.anotherlife.ui.screen.login.mapper.base

import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthModel
import com.alife.core.mapper.Mapper
import com.alife.domain.login.entity.AuthTypeEntity

interface BaseAuthTypeToUIAuth :
    Mapper<@JvmSuppressWildcards List<AuthTypeEntity>, @JvmSuppressWildcards List<UIAuthModel>>