package com.alife.anotherlife.ui.example.test.screen.reducer

import android.util.Log
import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.store.BaseUIStore
import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.example.test.custom_composable.TextsAction
import com.alife.anotherlife.ui.example.test.custom_composable.TextsActionToModel
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenState
import kotlinx.coroutines.flow.StateFlow

class TestScreenReducer(
    override val uiStore: BaseUIStore<TestScreenState, Nothing> = DefaultUIStore(TestScreenState()),
    private val textsActionToModel: TextsActionToModel = TextsActionToModel()
) : BaseVMReducer<TestScreenState, Nothing>(), TestReducer {

    override fun getFlowState(): StateFlow<TestScreenState> = uiStore.stateFlow

    override fun onTestTextAction(text: String) {
        uiStore.setState { copy(testScreenText = text) }
    }

    override fun onTestBoxAction(textAction: TextsAction) {
        uiStore.setState {
            copy(textsModel = textsActionToModel.reduce(textAction, textsModel))
        }
    }

    override fun onContinueClick() {
        uiStore.setState { copy(testScreenText = testScreenText + "a") }
        Log.e("TestScreenReducer", "Set Effect ContinueClick")
    }

}