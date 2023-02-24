package com.alife.anotherlife.ui.screen.registration.username

import com.alife.anotherlife.ui.screen.registration.base.RegistrationViewModel
import com.alife.anotherlife.ui.screen.registration.username.reducer.AbstractUsernameRegReducer
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UsernameRegistrationVM @Inject constructor(
    override val reducerVM: AbstractUsernameRegReducer
) : RegistrationViewModel(reducerVM)