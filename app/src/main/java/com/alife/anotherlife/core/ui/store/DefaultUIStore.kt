package com.alife.anotherlife.core.ui.store

import com.alife.core.mvi.MVI

class DefaultUIStore<STATE : MVI.State, EFFECT : MVI.Effect>(
    initState: STATE
) : BaseUIStore<STATE, EFFECT>(initState)