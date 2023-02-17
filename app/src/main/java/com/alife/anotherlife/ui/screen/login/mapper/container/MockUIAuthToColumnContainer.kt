package com.alife.anotherlife.ui.screen.login.mapper.container

import com.alife.anotherlife.ui.screen.login.mapper.base.BaseUIAuthToColumnUIAuth
import com.alife.anotherlife.ui.screen.login.model.buttons.ColumnContainerUIAuthModel
import com.alife.domain.login.entity.AuthTypeEntity
import javax.inject.Inject

class MockUIAuthToColumnContainer @Inject constructor() : BaseUIAuthToColumnUIAuth  {

    override fun map(inputModel: List<AuthTypeEntity>): List<ColumnContainerUIAuthModel> {
        return emptyList()
    }
}