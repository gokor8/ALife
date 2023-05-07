package com.alife.data.repository.main.create_alife.picture.model.file

import android.content.Context
import com.alife.data.repository.main.create_alife.file_model_base.file_builders.BasePathModel
import dagger.hilt.android.qualifiers.ApplicationContext

class CreateAlifePathModel(@ApplicationContext private val context: Context) : BasePathModel {
    override fun getPath() = context.filesDir.path
}