package com.alife.data.repository.main.create_alife.model.image

import com.alife.data.repository.main.create_alife.model.base.BaseReadFileModel
import com.alife.data.repository.main.create_alife.model.base.file_builders.BaseFileName
import com.alife.data.repository.main.create_alife.model.base.file_builders.BasePathModel
import com.alife.data.repository.main.create_alife.model.file.CreateAlifePathModel

class ImageReadFileModel(
    filePath: BasePathModel,
    fileName: BaseFileName
) : BaseReadFileModel.DefaultRead(filePath, fileName, JpegExtension())