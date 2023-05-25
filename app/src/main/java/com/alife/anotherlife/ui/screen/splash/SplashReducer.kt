package com.alife.anotherlife.ui.screen.splash

import android.util.Log
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.splash.state.SplashEffect
import com.alife.anotherlife.ui.screen.splash.state.SplashState
import com.alife.domain.registration.usecase.token.cloud.BaseTokenCheckUseCase
import javax.inject.Inject

class SplashReducer @Inject constructor(
    //private val tokensUseCase: BaseTokensUseCase,
    override val uiStore: UIStore<SplashState, SplashEffect>,
    private val tokenCheckUseCase: BaseTokenCheckUseCase
) : HandlerBaseVMReducer<SplashState, SplashEffect>(), BaseSplashReducer {

    override suspend fun onInit() {
        val navEffect = execute<SplashEffect> {
            Log.e("Aboba", "bad bad boy $it")
            SplashEffect.NavigateToLogin()
        }.handle {
            tokenCheckUseCase.tokensCheck()
            SplashEffect.NavigateToMain()
        }

        setEffect(navEffect)
    }
}