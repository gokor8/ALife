package com.alife.data.repository.main.create_alife.video.video

import android.content.Context
import com.alife.data.core.file_model_base.BaseFileModel
import com.alife.data.core.file_model_base.CreateAlifePathModel
import com.alife.data.repository.main.create_alife.video.model.VideoAlifeFileName

class Video(context: Context) : BaseFileModel.Abstract(
    CreateAlifePathModel(context),
    VideoAlifeFileName(),
    Mp4Extension()
)