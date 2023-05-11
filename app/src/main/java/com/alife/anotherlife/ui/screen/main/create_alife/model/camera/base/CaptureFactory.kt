package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base

import androidx.camera.core.UseCase

interface CaptureFactory<M : UseCase> {

    fun create(rotation: Int): M
}