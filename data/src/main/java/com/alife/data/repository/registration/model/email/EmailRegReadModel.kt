package com.alife.data.repository.registration.model.email

import com.alife.data.repository.registration.model.StringCacheRead
import com.alife.data.repository.registration.model.name.NameRegKey
import com.alife.domain.registration.core.addons.EmptyException
import com.alife.domain.registration.usecase.name.addons.NameException

class EmailRegReadModel: StringCacheRead(EmailRegKey()) {

    override fun onReadNull(): String = throw EmptyException()
}