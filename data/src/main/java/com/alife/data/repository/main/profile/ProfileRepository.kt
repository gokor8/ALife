package com.alife.data.repository.main.profile

import com.alife.domain.main.profile.entity.ProfileInfoEntity
import com.alife.domain.main.profile.repository.BaseProfileRepository
import javax.inject.Inject

class ProfileRepository @Inject constructor() : BaseProfileRepository {

    override suspend fun getPostProfile(username: String): ProfileInfoEntity {
        return ProfileInfoEntity(
            username,
            "Grixailo",
            "ARM",
            "Рыдцарь",
            "some url"
        )
    }
}