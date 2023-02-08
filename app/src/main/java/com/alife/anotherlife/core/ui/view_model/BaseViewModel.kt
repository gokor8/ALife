package com.alife.anotherlife.core.ui.view_model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.core.mvi.MVI
import com.alife.core.mvi.MVIReducer
import kotlinx.coroutines.launch

abstract class BaseViewModel<ACTION : MVI.Action, STATE : MVI.State, EFFECT : MVI.Effect>
    : ViewModel(), MVIReducer.Base<ACTION> {

    abstract val reducerVM: BaseVMReducer<STATE, EFFECT>

    @Composable
    fun getUIState(): STATE = reducerVM.getFlowState().collectAsState().value

    abstract suspend fun onAction(action: ACTION)

    override fun reduce(action: ACTION) {
        viewModelScope.launch {
            onAction(action)
        }
    }

}
/*
VMReducer(private val UIStore: UIStore<STATE, EFFECT>) : SomeReducerInterface

when(action) {
    is VMActionGo -> reducer.go(action)
    is VMActionSomething -> reducer.something(action)
    is CBAction -> reducer.setModel(cbMapper(action, model))
}
*/
