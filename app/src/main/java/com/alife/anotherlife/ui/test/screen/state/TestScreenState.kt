package com.alife.anotherlife.ui.test.screen.state

import com.alife.anotherlife.ui.test.custom_composable.TextsModel
import com.alife.core.mvi.MVI

data class TestScreenState(
    val testScreenText: String = "Aboba",
    val textsModel: TextsModel = TextsModel("", "", "")
) : MVI.State