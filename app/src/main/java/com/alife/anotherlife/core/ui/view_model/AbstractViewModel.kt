package com.alife.anotherlife.core.ui.view_model

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.alife.anotherlife.core.ui.reducer.VMReducer
import com.alife.anotherlife.core.ui.state_collector.NavigationOnEffectCollect
import com.alife.core.mvi.MVI
import com.alife.core.mvi.MVIReducer
import kotlinx.coroutines.launch

abstract class AbstractViewModel<ACTION : MVI.Action, STATE : MVI.State, EFFECT : MVI.Effect>
    : ViewModel(), BaseViewModel<ACTION, STATE, EFFECT> {

    protected abstract val reducerVM: VMReducer<STATE, EFFECT>

    @Composable
    override fun getUIState(): STATE = reducerVM.getStateCollector().collectAsState().value

    suspend fun collectEffect(navController: NavController) {
        reducerVM.getEffectCollector().collect(navController, this)
    }

    protected abstract suspend fun onAction(action: ACTION)

    override fun reduce(action: ACTION) {
        viewModelScope.launch {
            onAction(action)
        }
    }

}
