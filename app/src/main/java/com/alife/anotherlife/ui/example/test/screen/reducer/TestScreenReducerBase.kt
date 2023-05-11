package com.alife.anotherlife.ui.example.test.screen.reducer

import com.alife.anotherlife.core.ui.store.BaseUIStore
import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.ui.example.test.custom_composable.action.ClickAction
import com.alife.anotherlife.ui.example.test.custom_composable.action.TextCustomAction
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenEffect
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenState

class TestScreenReducerBase(
    override val uiStore: BaseUIStore<TestScreenState, TestScreenEffect> = DefaultUIStore(TestScreenState()),
) : TestBaseVMReducer(), TestReducer {

    override suspend fun onTestTextAction(text: String) {
        uiStore.setState { copy(testScreenText = text) }
    }

    override suspend fun onButtonClick() {
        uiStore.setState { copy(testScreenText = testScreenText + "a") }
    }

    override suspend fun onCustomTextBoxAction(textAction: TextCustomAction) {
        uiStore.setState {
            copy(textsModel = textAction.changeTextsModel(textsModel))
        }
    }

    override suspend fun onCustomClickBoxAction(clickAction: ClickAction) {
        clickAction.onClick(uiStore.getState().textsModel, this@TestScreenReducerBase)
    }

    override suspend fun onContinueClick() {
        uiStore.setEffect(TestScreenEffect.ForwardNext())
    }
}