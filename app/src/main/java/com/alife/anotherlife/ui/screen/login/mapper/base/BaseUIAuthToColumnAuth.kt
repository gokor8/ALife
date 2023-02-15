package com.alife.anotherlife.ui.screen.login.mapper.base

import com.alife.anotherlife.ui.screen.login.model.buttons.ColumnContainerUIAuthModel
import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthModel
import com.alife.core.mapper.Mapper

interface BaseUIAuthToColumnAuth :
    Mapper<@JvmSuppressWildcards List<UIAuthModel>,
           @JvmSuppressWildcards List<ColumnContainerUIAuthModel>>