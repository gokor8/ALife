package com.alife.anotherlife.ui.test.custom_composable

import com.alife.core.mvi.MVI

sealed class TextsAction(val text: String) : MVI.Action {

    class FirstTextAction(text: String) : TextsAction(text)
    class SecondTextAction(text: String) : TextsAction(text)
    class ThirdTextAction(text: String) : TextsAction(text)

}