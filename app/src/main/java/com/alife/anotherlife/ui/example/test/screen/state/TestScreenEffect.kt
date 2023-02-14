package com.alife.anotherlife.ui.example.test.screen.state

import com.alife.core.mvi.MVI

interface TestScreenEffect : MVI.Effect {
    class ForwardNext() : TestScreenEffect
}