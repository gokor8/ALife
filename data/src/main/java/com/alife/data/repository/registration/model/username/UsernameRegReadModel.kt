package com.alife.data.repository.registration.model.username

import com.alife.data.repository.registration.model.StringCacheRead
import com.alife.domain.registration.usecase.username.addons.UsernameException

class UsernameRegReadModel : StringCacheRead(UsernameRegKey()) {

    override fun onReadNull(): String = throw UsernameException()
}