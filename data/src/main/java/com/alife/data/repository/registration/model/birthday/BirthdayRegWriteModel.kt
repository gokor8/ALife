package com.alife.data.repository.registration.model.birthday

import com.alife.data.repository.registration.model.StringCacheWrite

class BirthdayRegWriteModel(saveValue: String) : StringCacheWrite(BirthdayRegKey(), saveValue)