package com.alife.anotherlife.ui.screen.registration.tutorial

import com.alife.anotherlife.core.ui.reducer.VMReducer
import com.alife.anotherlife.ui.screen.registration.tutorial.state.TutorialEffect
import com.alife.anotherlife.ui.screen.registration.tutorial.state.TutorialState

interface BaseTutorialReducer : VMReducer<TutorialState, TutorialEffect> {

    fun onScreenChanged(index: Int)

    suspend fun onContinue()
}