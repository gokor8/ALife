package com.alife.data.repository.registration.model.name

import com.alife.data.repository.registration.model.StringCacheWrite
import javax.inject.Inject

class NameRegWriteModel(saveValue: String) : StringCacheWrite(NameRegKey(), saveValue)