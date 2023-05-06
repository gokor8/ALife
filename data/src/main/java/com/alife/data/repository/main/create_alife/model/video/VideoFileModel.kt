package com.alife.data.repository.main.create_alife.model.video

import com.alife.data.repository.main.create_alife.model.base.BaseFileModel
import com.alife.data.repository.main.create_alife.model.base.file_builders.BasePathModel
import com.alife.data.repository.main.create_alife.model.file.VideoAlifeFileName

class VideoFileModel(
    pathModel: BasePathModel
) : BaseFileModel.AbstractFileModel(pathModel, VideoAlifeFileName(), Mp4Extension())