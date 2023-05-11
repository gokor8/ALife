package com.alife.data.repository.main.create_alife.picture.model.image

import com.alife.data.repository.main.create_alife.file_model_base.BaseReadFileModel
import com.alife.data.repository.main.create_alife.file_model_base.file_builders.BaseFileName
import com.alife.data.repository.main.create_alife.file_model_base.file_builders.BasePathModel

class ImageReadFileModel(
    filePath: BasePathModel,
    fileName: BaseFileName
) : BaseReadFileModel.DefaultRead(filePath, fileName, JpegExtension())