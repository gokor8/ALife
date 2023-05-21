package com.alife.data.interceptor.mapper

import com.alife.core.mapper.Mapper
import com.alife.data.interceptor.model.TokensModel
import com.alife.domain.registration.usecase.token.BaseTokensModel
import com.alife.domain.registration.usecase.token.TokenStateEntity
import javax.inject.Inject

class TokensModelToTokenStateEntity @Inject constructor() : Mapper<BaseTokensModel, TokenStateEntity> {
    override fun map(inputModel: BaseTokensModel): TokenStateEntity {
        return if (inputModel is TokensModel) {
            TokenStateEntity.Fill(
                inputModel.authorizationToken,
                inputModel.refreshToken
            )
        } else {
            TokenStateEntity.Empty()
        }
    }
}