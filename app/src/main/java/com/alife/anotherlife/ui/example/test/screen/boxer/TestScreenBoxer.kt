package com.alife.anotherlife.ui.example.test.screen.boxer

import com.alife.anotherlife.ui.example.test.custom_composable.action.TextCustomAction
import com.alife.anotherlife.ui.example.test.custom_composable.TextsBoxer
import com.alife.anotherlife.ui.example.test.custom_composable.action.CustomAction
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenAction

class TestScreenBoxer : TextsBoxer<TestScreenAction> {

    override fun map(inputModel: CustomAction): TestScreenAction {
        return TestScreenAction.TestBoxAction(inputModel)
    }
}