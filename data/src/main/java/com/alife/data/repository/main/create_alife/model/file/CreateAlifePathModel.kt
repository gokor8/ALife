package com.alife.data.repository.main.create_alife.model.file

import android.os.Environment
import com.alife.data.repository.main.create_alife.model.base.file_builders.BasePathModel

class CreateAlifePathModel : BasePathModel {
    override fun getPath() = Environment.getExternalStorageDirectory().toString()
}