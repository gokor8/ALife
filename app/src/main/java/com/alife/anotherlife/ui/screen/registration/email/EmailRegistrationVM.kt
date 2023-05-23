package com.alife.anotherlife.ui.screen.registration.email

import androidx.navigation.NavController
import com.alife.anotherlife.di.ui.registration.email.EmailAnnotation
import com.alife.anotherlife.ui.screen.registration.base.RegistrationViewModel
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducerBase
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EmailRegistrationVM @Inject constructor(
    @EmailAnnotation.EmailRegistration
    reducer: RegistrationReducerBase
) : RegistrationViewModel(reducer) {

    suspend fun collectEffect(navController: NavController, onDialogError: (Int) -> Unit) {
        reducerVM.getEffectCollector().collect { effect ->
            if (effect is RegistrationEffect.DialogError)
                onDialogError(effect.text)
            else
                onEffect(navController, effect)
        }
    }
}