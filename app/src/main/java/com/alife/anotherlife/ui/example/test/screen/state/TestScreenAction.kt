package com.alife.anotherlife.ui.example.test.screen.state

import com.alife.anotherlife.ui.example.test.custom_composable.TextsAction
import com.alife.core.mvi.MVI

sealed interface TestScreenAction : MVI.Action {

    class TestTextAction(val text: String) : TestScreenAction
    class TestContinueClick : TestScreenAction

    class TestBoxAction(val action: TextsAction) : TestScreenAction
}