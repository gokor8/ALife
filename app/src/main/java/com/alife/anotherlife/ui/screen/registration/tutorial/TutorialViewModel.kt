package com.alife.anotherlife.ui.screen.registration.tutorial

import com.alife.anotherlife.core.composable.mvi_extensions.DefaultViewModel
import com.alife.anotherlife.ui.screen.registration.tutorial.state.TutorialAction
import com.alife.anotherlife.ui.screen.registration.tutorial.state.TutorialEffect
import com.alife.anotherlife.ui.screen.registration.tutorial.state.TutorialState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TutorialViewModel @Inject constructor(
    override val reducerVM: BaseTutorialReducer
) : DefaultViewModel<BaseTutorialReducer, TutorialAction, TutorialState, TutorialEffect>(reducerVM)