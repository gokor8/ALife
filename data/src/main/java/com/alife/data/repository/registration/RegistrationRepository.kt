package com.alife.data.repository.registration

import android.content.SharedPreferences
import com.alife.data.repository.registration.model.RegEntityToRegModel
import com.alife.domain.registration.entity.RegistrationEntity
import com.alife.domain.registration.repository.BaseRegistrationRepository
import javax.inject.Inject

class RegistrationRepository @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val regEntityToRegModel: RegEntityToRegModel,
) : BaseRegistrationRepository {

    override fun saveRegData(regEntity: RegistrationEntity) {
        sharedPreferences.edit().also { editor ->
            regEntityToRegModel.map(regEntity).saveValue(editor)
        }.apply()
    }
}