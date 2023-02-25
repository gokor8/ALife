package com.alife.anotherlife.ui.screen.registration.birthday

import com.alife.anotherlife.di.ui.registration.birthday.BirthdayAnnotation
import com.alife.anotherlife.ui.screen.registration.base.RegistrationViewModel
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducer
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BirthdayRegistrationVM @Inject constructor(
    @BirthdayAnnotation.BirthdayRegistration
    reducerVM: RegistrationReducer
) : RegistrationViewModel(reducerVM)