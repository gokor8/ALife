package com.alife.data.repository.registration.model.name

import com.alife.data.repository.registration.model.StringCacheRead
import com.alife.domain.registration.usecase.reg_log.name.addons.NameException

class NameRegReadModel: StringCacheRead(NameRegKey()) {

    override fun onReadNull(): String = throw NameException()
}