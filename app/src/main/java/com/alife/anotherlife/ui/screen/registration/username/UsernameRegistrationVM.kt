package com.alife.anotherlife.ui.screen.registration.username

import com.alife.anotherlife.di.ui.registration.username.UsernameAnnotation
import com.alife.anotherlife.ui.screen.registration.base.RegistrationViewModel
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducer
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UsernameRegistrationVM @Inject constructor(
    @UsernameAnnotation.UsernameRegistration
    override val reducerVM: RegistrationReducer
) : RegistrationViewModel(reducerVM)