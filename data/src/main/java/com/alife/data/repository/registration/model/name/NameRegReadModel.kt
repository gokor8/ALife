package com.alife.data.repository.registration.model.name

import com.alife.data.repository.registration.model.StringCacheRead
import com.alife.domain.registration.usecase.name.addons.NameException
import javax.inject.Inject

class NameRegReadModel: StringCacheRead(NameRegKey()) {

    override fun onReadNull(): String = throw NameException()
}