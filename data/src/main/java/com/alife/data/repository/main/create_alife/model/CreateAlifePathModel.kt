package com.alife.data.repository.main.create_alife.model

import android.os.Environment
import com.alife.data.repository.main.create_alife.model.base.BasePathModel

class CreateAlifePathModel : BasePathModel {
    override fun getPath() =  Environment.getExternalStorageDirectory().toString()
}