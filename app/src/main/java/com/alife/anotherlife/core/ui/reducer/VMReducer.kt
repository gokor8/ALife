package com.alife.anotherlife.core.ui.reducer

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.core.mvi.MVI

interface VMReducer<STATE : MVI.State, EFFECT : MVI.Effect> {

    fun getStore(): UIStore<STATE, EFFECT>

}