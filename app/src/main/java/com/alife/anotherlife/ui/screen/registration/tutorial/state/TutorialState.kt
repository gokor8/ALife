package com.alife.anotherlife.ui.screen.registration.tutorial.state

import com.alife.anotherlife.ui.screen.registration.tutorial.childrens.BaseTutorialScreen
import com.alife.anotherlife.ui.screen.registration.tutorial.childrens.FirstTutorialScreen
import com.alife.anotherlife.ui.screen.registration.tutorial.childrens.SecondTutorialScreen
import com.alife.anotherlife.ui.screen.registration.tutorial.childrens.ThirdTutorialScreen
import com.alife.anotherlife.ui.screen.registration.tutorial.model.ButtonHeightState
import com.alife.core.mvi.MVI

data class TutorialState(
    val screenTutorsList: List<BaseTutorialScreen> = listOf(
        FirstTutorialScreen(),
        SecondTutorialScreen(),
        ThirdTutorialScreen()
    ),
    val buttonHeightState: ButtonHeightState = ButtonHeightState.Hide()
) : MVI.State