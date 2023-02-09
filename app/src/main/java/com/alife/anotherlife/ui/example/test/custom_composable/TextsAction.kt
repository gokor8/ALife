package com.alife.anotherlife.ui.example.test.custom_composable

import com.alife.core.mvi.MVI

sealed class TextsAction(val text: String) : MVI.Action {

    abstract fun onAction(model: TextsModel): TextsModel

    class FirstTextAction(text: String) : TextsAction(text) {
        override fun onAction(model: TextsModel): TextsModel {
            return model.copy(firstText = text)
        }
    }
    class SecondTextAction(text: String) : TextsAction(text) {
        override fun onAction(model: TextsModel): TextsModel {
            return model.copy(secondText = text)
        }
    }
    class ThirdTextAction(text: String) : TextsAction(text) {
        override fun onAction(model: TextsModel): TextsModel {
            return model.copy(thirdText = text)
        }
    }

    class ClickContinue() : TextsAction()

}