package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options

import androidx.camera.video.FileOutputOptions
import com.alife.data.repository.main.create_alife.video.entity.VideoStorageEntity
import javax.inject.Inject

interface BaseFileOutputOptions {

    fun options(): FileOutputOptions


    class Default(private val videoStorageEntity: VideoStorageEntity) : BaseFileOutputOptions {

        override fun options(): FileOutputOptions {
            return FileOutputOptions.Builder(videoStorageEntity.videoFile).build()
        }
    }
}