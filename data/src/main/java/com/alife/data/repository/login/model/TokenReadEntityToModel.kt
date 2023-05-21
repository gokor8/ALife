package com.alife.data.repository.login.model

import com.alife.data.data_source.cache.shared.model.CacheModel
import com.alife.domain.registration.usecase.token.TokenReadEntity
import javax.inject.Inject

class TokenReadEntityToModel @Inject constructor() : BaseTokenReadEntityToModel {

    override fun map(inputModel: TokenReadEntity): CacheModel.Read<*> {
        return CacheTokenModel.Read()
    }
}