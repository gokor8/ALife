package com.alife.anotherlife.ui.screen.login.mapper.base

import com.alife.anotherlife.ui.screen.login.model.buttons.ColumnContainerUIAuthModel
import com.alife.core.mapper.Mapper
import com.alife.domain.login.content.entity.AuthTypeEntity

interface BaseUIAuthToColumnUIAuth :
    Mapper<@JvmSuppressWildcards List<AuthTypeEntity>,
            @JvmSuppressWildcards List<ColumnContainerUIAuthModel>>