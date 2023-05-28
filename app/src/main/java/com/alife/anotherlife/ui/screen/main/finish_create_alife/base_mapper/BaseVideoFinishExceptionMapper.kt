package com.alife.anotherlife.ui.screen.main.finish_create_alife.base_mapper

import com.alife.anotherlife.R
import javax.inject.Inject

interface BaseVideoFinishExceptionMapper : BaseFinishExceptionMapper

class VideoFinishExceptionMapper @Inject constructor() : FinishExceptionMapper(
    R.string.upload_no_video_file_error, R.string.upload_no_video_file_error_description
), BaseVideoFinishExceptionMapper


