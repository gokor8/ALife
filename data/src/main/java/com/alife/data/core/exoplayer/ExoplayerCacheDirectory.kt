package com.alife.data.core.exoplayer

import android.content.Context
import com.alife.data.core.file_model_base.BaseFileModel
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import javax.inject.Inject

class ExoplayerCacheDirectory @Inject constructor(
    @ApplicationContext
    private val context: Context
) : BaseFileModel {

    private val folderName = "player_cache_media"

    override fun getFullPath(): String {
        return "${context.filesDir}/${folderName}"
    }
}