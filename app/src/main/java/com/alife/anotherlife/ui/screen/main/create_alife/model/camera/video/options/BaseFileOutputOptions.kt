package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options

import android.content.Context
import androidx.camera.video.FileOutputOptions
import com.alife.data.repository.main.create_alife.model.file.CreateAlifePathModel
import com.alife.data.repository.main.create_alife.model.video.VideoFileModel
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import javax.inject.Inject

interface BaseFileOutputOptions {

    fun options(): FileOutputOptions


    class Default @Inject constructor(
        @ApplicationContext private val context: Context
    ) : BaseFileOutputOptions {

        override fun options(): FileOutputOptions {
            val path = VideoFileModel(CreateAlifePathModel(context)).getFullFilePath()

            return FileOutputOptions.Builder(File(path)).build()
        }
    }
}