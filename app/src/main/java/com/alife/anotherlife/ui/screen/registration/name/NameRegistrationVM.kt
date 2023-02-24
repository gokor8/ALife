package com.alife.anotherlife.ui.screen.registration.name

import com.alife.anotherlife.ui.screen.registration.base.RegistrationViewModel
import com.alife.anotherlife.ui.screen.registration.name.reducer.AbstractNameRegReducer
import com.alife.anotherlife.ui.screen.registration.name.reducer.NameRegistrationReducer
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NameRegistrationVM @Inject constructor(
    reducer: AbstractNameRegReducer
) : RegistrationViewModel(reducer)