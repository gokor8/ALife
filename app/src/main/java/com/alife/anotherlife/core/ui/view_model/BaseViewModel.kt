package com.alife.anotherlife.core.ui.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alife.anotherlife.core.ui.store.Store
import com.alife.core.mvi.MVI
import com.alife.core.mvi.MVIReducer
import kotlinx.coroutines.launch

abstract class BaseViewModel<ACTION : MVI.Action, STATE : MVI.State, EFFECT : MVI.Effect>
    : ViewModel(), MVIReducer.Base<ACTION> {

    abstract val store: Store<STATE, EFFECT>


    abstract suspend fun onAction(action: ACTION)

    override fun reduce(action: ACTION) {
        viewModelScope.launch {
            onAction(action)
        }
    }

}