package com.alife.data.repository.login.model

import com.alife.data.data_source.cache.shared.model.CacheModel
import com.alife.domain.registration.usecase.token.cache.TokenSaveEntity
import javax.inject.Inject

class TokenSaveEntityToModel @Inject constructor() : BaseTokenSaveEntityToModel {

    override fun map(inputModel: TokenSaveEntity): CacheModel.Write<*> {
        return CacheTokenModel.Write(inputModel.accessToken, inputModel.refreshToken)
    }
}