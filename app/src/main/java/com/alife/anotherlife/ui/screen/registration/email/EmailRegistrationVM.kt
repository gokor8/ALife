package com.alife.anotherlife.ui.screen.registration.email

import com.alife.anotherlife.di.ui.registration.email.EmailAnnotation
import com.alife.anotherlife.ui.screen.registration.base.RegistrationViewModel
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducerBase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EmailRegistrationVM @Inject constructor(
    @EmailAnnotation.EmailRegistration
    reducer: RegistrationReducerBase
) : RegistrationViewModel(reducer)