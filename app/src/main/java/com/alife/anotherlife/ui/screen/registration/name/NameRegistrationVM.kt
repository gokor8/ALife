package com.alife.anotherlife.ui.screen.registration.name

import com.alife.anotherlife.di.ui.registration.name.NameAnnotation
import com.alife.anotherlife.ui.screen.registration.base.RegistrationViewModel
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducer
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NameRegistrationVM @Inject constructor(
    @NameAnnotation.NameRegistration
    reducer: RegistrationReducer
) : RegistrationViewModel(reducer)