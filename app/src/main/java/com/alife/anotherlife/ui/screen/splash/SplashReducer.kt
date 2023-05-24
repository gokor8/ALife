package com.alife.anotherlife.ui.screen.splash

import android.util.Log
import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.splash.state.SplashEffect
import com.alife.anotherlife.ui.screen.splash.state.SplashState
import com.alife.domain.registration.usecase.token.cache.BaseTokensUseCase
import com.alife.domain.registration.usecase.token.cache.TokenStateEntity
import com.alife.domain.registration.usecase.token.cloud.BaseTokenCheckUseCase
import javax.inject.Inject

class SplashReducer @Inject constructor(
    override val uiStore: UIStore<SplashState, SplashEffect>,
    private val tokensUseCase: BaseTokensUseCase,
    private val tokenCheckUseCase: BaseTokenCheckUseCase
) : AbstractVMReducer<SplashState, SplashEffect>(), BaseSplashReducer {

    override suspend fun onInit() {
        val navEffect = if (tokensUseCase.getTokens() is TokenStateEntity.Empty) {
            SplashEffect.NavigateToLogin()
        } else {
            try {
                tokenCheckUseCase.tokensCheck()
            } catch (e: Exception) {
                // TODO NavToLogin
                setEffect(SplashEffect.NavigateToLogin())
                Log.d("Aboba", "exception $e")
                return
            }
            SplashEffect.NavigateToMain()
        }

        setEffect(navEffect)
    }
}