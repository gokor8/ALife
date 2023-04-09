package com.alife.data.repository.main.create_alife.model.file

import android.content.Context
import android.os.Environment
import com.alife.data.repository.main.create_alife.model.base.file_builders.BasePathModel
import dagger.hilt.android.qualifiers.ApplicationContext

class CreateAlifePathModel(@ApplicationContext private val context: Context) : BasePathModel {
    override fun getPath() = context.filesDir.path
}