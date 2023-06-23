package com.alife.anotherlife.ui.screen.main.navigation_bar.home.state

import com.alife.core.mvi.MVI

interface HomeEffect : MVI.Effect {

    class Refresh() : HomeEffect

    class ChangePagerItemEffect(val position: Int) : HomeEffect
}