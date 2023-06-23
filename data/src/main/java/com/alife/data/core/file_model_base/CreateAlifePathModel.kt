package com.alife.data.core.file_model_base

import android.content.Context
import com.alife.data.core.file_model_base.file_builders.BasePathModel
import dagger.hilt.android.qualifiers.ApplicationContext

class CreateAlifePathModel(@ApplicationContext private val context: Context) : BasePathModel {
    override fun getPath() = context.filesDir.path
}