package com.alife.anotherlife.core.ui.store

import com.alife.core.mvi.MVI
import dagger.Reusable
import javax.inject.Inject

class DefaultUIStore<STATE : MVI.State, EFFECT : MVI.Effect>
@Inject constructor(
    initState: STATE
) : BaseUIStore<STATE, EFFECT>(initState)