package com.alife.anotherlife.ui.screen.login.mapper.container

import com.alife.anotherlife.ui.screen.login.mapper.base.BaseListAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseUIAuthToColumnUIAuth
import com.alife.anotherlife.ui.screen.login.model.buttons.ColumnContainerUIAuthModel
import com.alife.core.mapper.ListMapperSingle
import com.alife.domain.login.content.entity.AuthTypeEntity
import javax.inject.Inject

class UIAuthToColumnContainerUIAuth @Inject constructor(
    private val listAuthTypeToUIAuth: BaseListAuthTypeToUIAuth,
    private val listSliceMapper: ListMapperSingle<AuthTypeEntity>
) : BaseUIAuthToColumnUIAuth {

    override fun map(inputModel: List<AuthTypeEntity>): List<ColumnContainerUIAuthModel> {
        val slicedList = listSliceMapper.map(inputModel)
        val uiAuthModel = listAuthTypeToUIAuth.map(slicedList)

        return mutableListOf<ColumnContainerUIAuthModel>().apply {
            for (index in uiAuthModel.indices step 2) {
                if (index == uiAuthModel.size - 1) {
                    ColumnContainerUIAuthModel(uiAuthModel[index])
                } else {
                    ColumnContainerUIAuthModel(
                        uiAuthModel[index],
                        uiAuthModel[index + 1]
                    )
                }.also(::add)
            }
        }
    }
}