package com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.model

import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options.BaseVideoCaptureBuilder

interface BaseVideoCaptureBuilderFactory {

    fun getBuilder(isAudioEnabled: Boolean): BaseVideoCaptureBuilder
}