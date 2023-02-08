package com.alife.anotherlife.ui.test.screen

import com.alife.anotherlife.core.ui.view_model.BaseViewModel
import com.alife.anotherlife.ui.test.custom_composable.TextsActionToModel
import com.alife.anotherlife.ui.test.screen.reducer.TestScreenReducer
import com.alife.anotherlife.ui.test.screen.state.TestScreenAction
import com.alife.anotherlife.ui.test.screen.state.TestScreenState

class TestViewModel : BaseViewModel<TestScreenAction, TestScreenState, Nothing>() {

    private val textsActionToModel = TextsActionToModel()

    override val reducerVM = TestScreenReducer()

    override suspend fun onAction(action: TestScreenAction) {
        when (action) {
            is TestScreenAction.TestTextAction -> reducerVM.reduce(action)
            is TestScreenAction.TestContinueClick -> reducerVM.reduce(action)
            is TestScreenAction.TestBoxAction -> {
                reducerVM.reduceModel(
                    textsActionToModel.reduce(
                        action.action,
                        reducerVM.UIStore.getState().textsModel
                    )
                )
            }
        }
    }
}