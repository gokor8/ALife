package com.alife.anotherlife.ui.screen.login.mapper.container

import com.alife.anotherlife.ui.screen.login.mapper.base.BaseListAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseUIAuthToColumnUIAuth
import com.alife.anotherlife.ui.screen.login.model.buttons.ColumnContainerUIAuthModel
import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthModel
import com.alife.domain.login.entity.AuthTypeEntity
import javax.inject.Inject

class UIAuthToColumnContainerUIAuth @Inject constructor(
    private val listAuthTypeToUIAuth: BaseListAuthTypeToUIAuth
) : BaseUIAuthToColumnUIAuth {

    override fun map(inputModel: List<AuthTypeEntity>): List<ColumnContainerUIAuthModel> {
        val uiAuthModel = listAuthTypeToUIAuth.map(inputModel)

        return mutableListOf<ColumnContainerUIAuthModel>().apply {
            for (index in uiAuthModel.indices step 2) {
                ColumnContainerUIAuthModel(
                    uiAuthModel[index - 1],
                    uiAuthModel[index]
                ).also(::add)
            }

            if (inputModel.size % 2 == 1) {
                ColumnContainerUIAuthModel(uiAuthModel.last()).also(::add)
            }
        }
    }
}