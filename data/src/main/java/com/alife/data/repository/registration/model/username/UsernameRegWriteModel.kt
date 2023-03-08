package com.alife.data.repository.registration.model.username

import com.alife.data.repository.registration.model.StringCacheWrite

class UsernameRegWriteModel(saveValue: String) : StringCacheWrite(UsernameRegKey(), saveValue)