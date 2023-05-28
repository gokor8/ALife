package com.alife.data.repository.login.model

import android.content.SharedPreferences
import com.alife.data.data_source.cache.shared.model.CacheModel
import com.alife.data.interceptor.model.TokensModel
import java.io.IOException

interface CacheTokenModel : CacheModel<TokensModel> {

    override fun getKey(): String = "tokens"


    abstract class Abstract : CacheTokenModel {
        protected fun keyAuth() = getKey() + "_auth"
        protected fun keyRefresh() = getKey() + "_refresh"
    }

    class Write(
        private val authorizationToken: String,
        private val refreshToken: String
    ) : CacheModel.Write<TokensModel>, Abstract() {

        override fun write(editor: SharedPreferences.Editor) {
            editor.putString(keyAuth(), authorizationToken)
            editor.putString(keyRefresh(), refreshToken)
        }
    }

    class Read : CacheTokenModel, CacheModel.Read<TokensModel>, Abstract() {

        override fun read(sharedPreferences: SharedPreferences): TokensModel {
            val exception = IOException("NotFound token")

            val auth = sharedPreferences.getString(keyAuth(), null) ?: throw exception
            val refresh = sharedPreferences.getString(keyRefresh(), null) ?: throw exception

            return TokensModel(auth, refresh)
        }

        override fun delete(editor: SharedPreferences.Editor) {
            editor.remove(keyAuth())
            editor.remove(keyRefresh())
        }
    }
}