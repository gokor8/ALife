package com.alife.anotherlife.ui.example.test.custom_composable.action

import com.alife.anotherlife.ui.example.test.custom_composable.TextsModel

sealed class TextCustomAction(val text: String) : CustomAction {

    abstract fun changeTextsModel(model: TextsModel): TextsModel

    class FirstTextAction(text: String) : TextCustomAction(text) {
        override fun changeTextsModel(model: TextsModel): TextsModel {
            return model.copy(firstText = text)
        }
    }
    class SecondTextAction(text: String) : TextCustomAction(text) {
        override fun changeTextsModel(model: TextsModel): TextsModel {
            return model.copy(secondText = text)
        }
    }
    class ThirdTextAction(text: String) : TextCustomAction(text) {
        override fun changeTextsModel(model: TextsModel): TextsModel {
            return model.copy(thirdText = text)
        }
    }

}