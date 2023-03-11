package com.alife.data.repository.registration.model.birthday

import com.alife.data.repository.registration.model.StringCacheRead
import com.alife.domain.registration.core.addons.EmptyException

class BirthdayRegReadModel : StringCacheRead(BirthdayRegKey()) {

    override fun onReadNull(): String = throw EmptyException()
}