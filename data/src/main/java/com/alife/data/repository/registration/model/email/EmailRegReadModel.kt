package com.alife.data.repository.registration.model.email

import com.alife.data.repository.registration.model.StringCacheRead
import com.alife.domain.registration.core.addons.EmptyException

class EmailRegReadModel: StringCacheRead(EmailRegKey()) {

    override fun onReadNull(): String = throw EmptyException()
}