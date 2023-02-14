package com.alife.anotherlife.ui.example.test.custom_composable

// This model, not state
data class TextsModel(
    val firstText: String,
    val secondText: String,
    val thirdText: String
) {

    fun isNotEmpty() = firstText.isNotEmpty() && secondText.isNotEmpty() && thirdText.isNotEmpty()
}