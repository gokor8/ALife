package com.alife.anotherlife.ui.example.test.screen.boxer

import com.alife.anotherlife.ui.example.test.custom_composable.TextsAction
import com.alife.anotherlife.ui.example.test.custom_composable.TextsBoxer
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenAction

class TestScreenBoxer : TextsBoxer<TestScreenAction> {

    override fun map(inputModel: TextsAction): TestScreenAction {
        return TestScreenAction.TestBoxAction(inputModel)
    }
}