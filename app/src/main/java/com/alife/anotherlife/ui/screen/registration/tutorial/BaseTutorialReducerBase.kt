package com.alife.anotherlife.ui.screen.registration.tutorial

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.screen.registration.tutorial.state.TutorialEffect
import com.alife.anotherlife.ui.screen.registration.tutorial.state.TutorialState

interface BaseTutorialReducerBase : BaseVMReducer<TutorialState, TutorialEffect> {

    fun onScreenChanged(index: Int)

    suspend fun onContinue()
}