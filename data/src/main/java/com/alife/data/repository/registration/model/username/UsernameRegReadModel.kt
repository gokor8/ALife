package com.alife.data.repository.registration.model.username

import com.alife.data.repository.registration.model.StringCacheRead

class UsernameRegReadModel : StringCacheRead(UsernameRegKey()) {

    override fun onReadNull(): String = throw UsernameException()
}