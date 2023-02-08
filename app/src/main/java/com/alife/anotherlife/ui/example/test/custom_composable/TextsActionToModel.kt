package com.alife.anotherlife.ui.example.test.custom_composable

import com.alife.core.mvi.MVIMapper

class TextsActionToModel : MVIMapper<TextsAction, TextsModel> {

    override suspend fun reduce(action: TextsAction, model: TextsModel): TextsModel {
        return when(action) {
            is TextsAction.FirstTextAction -> model.copy(firstText = action.text)
            is TextsAction.SecondTextAction -> model.copy(secondText = action.text)
            is TextsAction.ThirdTextAction -> model.copy(thirdText = action.text)
        }
    }
}