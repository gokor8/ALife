package com.alife.data.repository.main.create_alife.model.image

import com.alife.data.repository.main.create_alife.model.base.BaseReadFileModel
import com.alife.data.repository.main.create_alife.model.base.file_builders.BaseFileName
import com.alife.data.repository.main.create_alife.model.file.CreateAlifePathModel

class ImageReadFileModel(
    fileName: BaseFileName
) : BaseReadFileModel.DefaultRead(CreateAlifePathModel(), fileName, JpegExtension())