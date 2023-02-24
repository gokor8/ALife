package com.alife.anotherlife.ui.screen.registration.birthday

import com.alife.anotherlife.di.ui.registration.birthday.BirthdayAnnotation
import com.alife.anotherlife.ui.screen.registration.base.RegistrationViewModel
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducer
import javax.inject.Inject

class BirthdayRegistrationVM @Inject constructor(
    @BirthdayAnnotation.BirthdayRegistration
    reducerVM: RegistrationReducer
) : RegistrationViewModel(reducerVM)