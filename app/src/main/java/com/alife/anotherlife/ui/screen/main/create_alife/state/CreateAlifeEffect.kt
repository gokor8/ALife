package com.alife.anotherlife.ui.screen.main.create_alife.state

import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.core.mvi.MVI

interface CreateAlifeEffect : MVI.Effect {

    class CreateAlifeFinish : CreateAlifeEffect, NavigationWrapper.Back()
}