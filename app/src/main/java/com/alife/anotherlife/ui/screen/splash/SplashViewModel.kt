package com.alife.anotherlife.ui.screen.splash

import com.alife.anotherlife.core.composable.mvi_extensions.DefaultViewModel
import com.alife.anotherlife.ui.screen.splash.state.SplashAction
import com.alife.anotherlife.ui.screen.splash.state.SplashEffect
import com.alife.anotherlife.ui.screen.splash.state.SplashState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    override val reducerVM: BaseSplashReducer
) : DefaultViewModel<BaseSplashReducer, SplashAction, SplashState, SplashEffect>(reducerVM)