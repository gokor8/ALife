package com.alife.anotherlife.ui.screen.splash

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.screen.splash.state.SplashEffect
import com.alife.anotherlife.ui.screen.splash.state.SplashState

interface BaseSplashReducer : BaseVMReducer<SplashState, SplashEffect> {

    suspend fun onInit()
}