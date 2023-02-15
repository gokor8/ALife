package com.alife.anotherlife.ui.screen.login.mapper

import com.alife.anotherlife.ui.screen.login.mapper.base.BaseUIAuthToColumnAuth
import com.alife.anotherlife.ui.screen.login.model.buttons.ColumnContainerUIAuthModel
import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthModel

class UIAuthToColumnAuth : BaseUIAuthToColumnAuth {

    override fun map(inputModel: List<UIAuthModel>): List<ColumnContainerUIAuthModel> {
        val listColumnContainer = mutableListOf<ColumnContainerUIAuthModel>()

        for (index in inputModel.indices step 2) {
            listColumnContainer.add(
                ColumnContainerUIAuthModel(
                    inputModel[index - 1],
                    inputModel[index]
                )
            )
        }

        if (inputModel.size % 2 == 1) {
            listColumnContainer.add(
                ColumnContainerUIAuthModel(
                    inputModel.last()
                )
            )
        }
    }
}