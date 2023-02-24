package com.alife.anotherlife.ui.screen.registration.name

import com.alife.anotherlife.ui.screen.registration.base.RegistrationViewModel
import com.alife.anotherlife.ui.screen.registration.name.reducer.NameRegistrationReducer
import javax.inject.Inject

class NameRegistrationVM @Inject constructor(
    reducer: NameRegistrationReducer
) : RegistrationViewModel(reducer)