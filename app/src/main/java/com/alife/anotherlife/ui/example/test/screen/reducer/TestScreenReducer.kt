package com.alife.anotherlife.ui.example.test.screen.reducer

import android.util.Log
import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.store.BaseUIStore
import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.example.test.custom_composable.TextsModel
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenAction
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenState
import kotlinx.coroutines.flow.StateFlow

class TestScreenReducer : BaseVMReducer<TestScreenState, Nothing>() {

    override val UIStore: BaseUIStore<TestScreenState, Nothing> = DefaultUIStore(TestScreenState())

    override fun getFlowState(): StateFlow<TestScreenState> {
        return UIStore.stateFlow
    }

    override fun getStore(): UIStore<TestScreenState, Nothing> = UIStore

    fun reduce(action: TestScreenAction.TestTextAction) {
        UIStore.setState { copy(testScreenText = action.text) }
    }

    fun reduce(action: TestScreenAction.TestContinueClick) {
        UIStore.setState { copy(testScreenText = testScreenText + "a") }
        Log.e("TestScreenReducer", "Set Effect ContinueClick")
    }

    fun reduceModel(model: TextsModel) {
        UIStore.setState { copy(textsModel = model) }
    }

}