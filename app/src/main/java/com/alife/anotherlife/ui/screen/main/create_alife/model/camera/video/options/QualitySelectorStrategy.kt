package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options

import androidx.camera.video.FallbackStrategy
import androidx.camera.video.Quality
import androidx.camera.video.QualitySelector

interface QualitySelectorStrategy {

    fun buildSelector(): QualitySelector


    class Default : QualitySelectorStrategy {

        override fun buildSelector() = QualitySelector.from(
            Quality.HD,
            FallbackStrategy.higherQualityOrLowerThan(Quality.HD)
        )
    }
}