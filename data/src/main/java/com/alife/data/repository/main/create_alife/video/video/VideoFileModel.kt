package com.alife.data.repository.main.create_alife.video.video

import android.content.Context
import com.alife.data.repository.main.create_alife.file_model_base.BaseFileModel
import com.alife.data.repository.main.create_alife.picture.model.file.CreateAlifePathModel
import com.alife.data.repository.main.create_alife.picture.model.file.VideoAlifeFileName

class VideoFileModel(context: Context) : BaseFileModel.AbstractFileModel(
    CreateAlifePathModel(context),
    VideoAlifeFileName(),
    Mp4Extension()
)