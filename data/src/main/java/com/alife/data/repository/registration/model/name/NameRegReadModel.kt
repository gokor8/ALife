package com.alife.data.repository.registration.model.name

import com.alife.data.repository.registration.model.StringCacheRead
import javax.inject.Inject

class NameRegReadModel @Inject constructor(): StringCacheRead(NameRegKey()) {

    override fun defaultValue(): String = ""

    override fun onReadNull(): String = throw NameException()
}