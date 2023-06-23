package com.alife.data.repository.main.profile

import com.alife.data.core.file_model_base.file_builders.BaseFileName

class ChangingPhotoFileName : BaseFileName {
    override fun getFileName() = "newProfilePhoto"
}