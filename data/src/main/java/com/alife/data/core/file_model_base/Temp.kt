package com.alife.data.core.file_model_base

import com.alife.data.core.file_model_base.file_builders.BaseFileExtension
import com.alife.data.core.file_model_base.file_builders.BaseFileName
import com.alife.data.core.file_model_base.file_builders.BasePathModel

class TempFileName : BaseFileName {
    override fun getFileName() = "temp"
}

class Temp(
    filePathModel: BasePathModel,
    fileExtension: BaseFileExtension
) : BaseFileModel.Abstract(filePathModel, TempFileName(), fileExtension)